package com.happywebsocketbirthday.base

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.happywebsocketbirthday.enums.DialogTypes
import com.happywebsocketbirthday.events.Event
import com.happywebsocketbirthday.events.IEventBus
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

abstract class BaseViewModel<ViewAction : BaseAction<ViewState>, ViewState> : ViewModel() {
    protected abstract val _viewState: MutableStateFlow<ViewState>
    val viewState by lazy { _viewState.asStateFlow() }

    @Inject
    open lateinit var eventBus: IEventBus

    private val actionSubject: MutableSharedFlow<ViewAction> = MutableSharedFlow()
    private val exceptionHandler = CoroutineExceptionHandler { _, exception -> }

    private val _networkFlow = MutableSharedFlow<NetworkCallModel>(
        replay = 1,
        extraBufferCapacity = 4
    )
    private val networkFlow: SharedFlow<NetworkCallModel> = _networkFlow.asSharedFlow()
    private var activeNetworkCalls = 0

    init {
        actionSubject
            .onEach(::processAction)
            .launchIn(viewModelScope)

        execute {
            networkFlow.collect { networkCall ->
                startNetworkCall(
                    call = networkCall.call,
                    onSuccess = networkCall.onSuccess,
                    onError = networkCall.onError,
                    withLoader = networkCall.withLoader
                )
            }
        }
    }

    @CallSuper
    protected open fun onActionReceived(viewAction: ViewAction) {
        if (viewAction is Event) {
            eventBus.produceEvent(viewAction)
        }
    }

    fun execute(
        coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO,
        call: suspend (CoroutineScope) -> Unit
    ) {
        viewModelScope.launch(coroutineDispatcher + exceptionHandler) {
            call(this)
        }
    }

    fun postAction(action: ViewAction) {
        viewModelScope.launch {
            action.updateData(_viewState)
            actionSubject.emit(action)
        }
    }

    private fun processAction(viewAction: ViewAction) {
        onActionReceived(viewAction)
    }

    protected fun <Result : Any> handleNetworkCall(
        call: suspend () -> Result,
        onSuccess: suspend (Result) -> Unit,
        onError: suspend (ErrorResponse?) -> Unit = {},
        withLoader: Boolean = true
    ) {
        val networkCall = NetworkCallModel(
            call = call,
            onSuccess = onSuccess as suspend (Any) -> Unit,
            onError = onError,
            withLoader = withLoader
        )

        execute {
            _networkFlow.emit(networkCall)
        }
    }

    private suspend fun <Result : Any> startNetworkCall(
        call: suspend () -> Result,
        onSuccess: suspend (Result) -> Unit,
        onError: suspend (ErrorResponse?) -> Unit = {},
        withLoader: Boolean
    ) {
        val startTime = System.currentTimeMillis()
        if (withLoader) {
            if (activeNetworkCalls == 0) {
                eventBus.produceEvent(Event.ShowLoader(true))
            }
            activeNetworkCalls++
        }

        try {
            onSuccess(
                call().also {
                    if (withLoader) {
                        delayLoaderIfNeeded(startTime)
                    }
                }
            )
        } catch (e: Exception) {
            handleNetworkCallException(e, onError)
        } finally {
            if (withLoader) {
                delayLoaderIfNeeded(startTime)
                activeNetworkCalls--
                if (activeNetworkCalls == 0) {
                    eventBus.produceEvent(Event.ShowLoader(false))
                }
            }
        }
    }

    private suspend fun handleNetworkCallException(
        e: Exception,
        onError: suspend (ErrorResponse?) -> Unit
    ) {
        when (e) {
            is ResponseException -> {
                when (e.error.errorCode) {
                    UNAUTHORIZED_HTTP_CODE -> onError(e.error) // Nothing should happen here
                    NOT_ACCEPTABLE_CODE -> onError(e.error) // Logic extends into the screens
                    else -> {
                        val title = if (e.error is DefaultError) e.error.title else null
                        val description = if (e.error is DefaultError) e.error.message else null
                        showErrorDialog(title = title, description = description)
                        onError(e.error)
                    }
                }
            }

            is CoreException.UnauthorizedException -> {
                //NAVIGATE TO INITIAL SCREEN IF SUCH RECEVIED HERE
            }

            is CoreException.NoInternetException -> {
                eventBus.produceEvent(Event.ShowCommonDialog(DialogTypes.NO_INTERNET))
            }

            is CoreException.TimeOutException -> {
                eventBus.produceEvent(Event.ShowCommonDialog(DialogTypes.CONNECTION_TIMEOUT))
            }

            is CoreException.UnknownException -> {
                showErrorDialog()
            }

            else -> {
                showErrorDialog()
            }
        }
    }

    private suspend fun delayLoaderIfNeeded(startTime: Long) {
        if ((System.currentTimeMillis() - startTime) >= DEFAULT_LOADER_TIME_MILLIS) {
            return
        } else {
            delay(DEFAULT_LOADER_TIME_MILLIS)
        }
    }

    private fun showErrorDialog(
        title: String? = null,
        description: String? = null
    ) {
        if (title != null || description != null) {
            eventBus.produceEvent(
                Event.ShowCommonDialog(
                    DialogTypes.SOMETHING_WENT_WRONG.apply {
                        titleString = title
                        subTitleString = description
                    }
                )
            )
        } else {
            eventBus.produceEvent(Event.ShowCommonDialog(DialogTypes.SERVICE_UNAVAILABLE))
        }
    }

    companion object {
        private const val DEFAULT_LOADER_TIME_MILLIS = 500L
        private const val UNAUTHORIZED_HTTP_CODE = 401
        const val NOT_ACCEPTABLE_CODE = 406
    }
}

