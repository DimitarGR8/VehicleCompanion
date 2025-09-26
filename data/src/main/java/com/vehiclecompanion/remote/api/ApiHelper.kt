package com.vehiclecompanion.remote.api

import com.google.gson.Gson
import com.vehiclecompanion.base.CoreException
import com.vehiclecompanion.base.DefaultError
import com.vehiclecompanion.base.ErrorResponse
import com.vehiclecompanion.base.NoError
import com.vehiclecompanion.base.ResponseException
import com.vehiclecompanion.base.generateExceptionByErrorCode
import com.vehiclecompanion.events.Event
import com.vehiclecompanion.events.IEventBus
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.job
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.io.InterruptedIOException
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.coroutineContext

@Singleton
class ApiHelper @Inject constructor(
    private val gson: Gson,
    private val iEventBus: IEventBus
) {
    companion object {
        private const val UNAUTHORIZED_HTTP_CODE = 401
    }

    private var refreshTokenJob: Job? = null

    /**
     * Invokes [networkCall] which doesn't have a specific error response,
     * so [NoError] class is used as error type
     */
    suspend fun <Result> makeApiCall(
        withRefreshToken: Boolean = true,
        networkCall: suspend () -> Response<Result>
    ): Result {
        return makeApiCallWithError<Result, DefaultError>(networkCall, withRefreshToken)
    }

    /**
     * Invokes [networkCall] which can return error with json body,
     * if error type is not [NoError], deserializes json body to [Error] type model and throws
     * [ResponseException]
     * if not, generates [GeneralException] by error code
     */
    private suspend inline fun <Result, reified Error : ErrorResponse> makeApiCallWithError(
        noinline networkCall: suspend () -> Response<Result>,
        withRefreshToken: Boolean
    ): Result {
        return apiCall(networkCall, withRefreshToken) { error ->
            if (Error::class != NoError::class && error.body != null) {
                val errorResponse = gson.fromJson(error.body, Error::class.java)
                errorResponse.errorCode = error.code
                throw ResponseException(error = errorResponse)
            }
            throw generateExceptionByErrorCode(
                code = error.code,
                message = error.body ?: ""
            )
        }
    }

    /**
     * Tries to call [networkCall] and if it is successful returns result,
     * handles and throws [GeneralException]
     * Invokes [onError] if general exceptions was not caught and result is not successful
     */
    private suspend fun <Result> apiCall(
        networkCall: suspend () -> Response<Result>,
        withRefreshToken: Boolean,
        onError: suspend (ErrorBody) -> Unit
    ): Result {
        val networkCallResult = tryNetworkCall(networkCall)

        if (networkCallResult.isSuccessful && networkCallResult.body() != null) {
            return networkCallResult.body()!!
        }

        if (withRefreshToken && networkCallResult.code() == UNAUTHORIZED_HTTP_CODE) {
            refreshTokenIfNeeded()
            val secondTryResult = tryNetworkCall(networkCall)
            return when {
                secondTryResult.isSuccessful && secondTryResult.body() != null -> secondTryResult.body()!!
                secondTryResult.code() == UNAUTHORIZED_HTTP_CODE -> throw CoreException.UnauthorizedException
                else -> {
                    onError(
                        ErrorBody(
                            code = secondTryResult.code(),
                            body = secondTryResult.errorBody()?.string()
                        )
                    )
                    throw CoreException.UnknownException(code = 0)
                }
            }
        } else if (networkCallResult.code() == UNAUTHORIZED_HTTP_CODE) {
            iEventBus.produceEvent(Event.ShowLoader(false))
            //KICK USER OUT IF NEEDED VIA EVENT

            throw CoreException.UnauthorizedException
        } else {
            onError(
                ErrorBody(
                    code = networkCallResult.code(),
                    body = networkCallResult.errorBody()?.string()
                )
            )

            throw CoreException.UnknownException(code = 0)
        }
    }

    private suspend fun refreshTokenIfNeeded() {
        if (refreshTokenJob?.isActive != true) {
            val deferred = CompletableDeferred<Unit>()
            refreshTokenJob = coroutineContext.job

            //REFRESSH BEARER TOKEN IF NEEDED VIA COMMAND TO EXECUTE THE PROCESS
            deferred.await()
        }
    }

    private suspend fun <Result> tryNetworkCall(
        networkCall: suspend () -> Response<Result>
    ): Response<Result> {
        return try {
            networkCall()
        } catch (e: CancellationException) {
            throw e
        } catch (e: HttpException) {
            throw CoreException.NoInternetException
        } catch (e: InterruptedIOException) {
            throw CoreException.TimeOutException
        } catch (e: IOException) {
            throw CoreException.NoInternetException
        } catch (e: Exception) {
            throw CoreException.UnknownException(code = 0)
        }
    }

    data class ErrorBody(val code: Int, val body: String?)
}
