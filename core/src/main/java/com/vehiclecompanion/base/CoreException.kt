package com.vehiclecompanion.base

/**
 * General Exceptions that can happen inside application
 */
sealed class CoreException : Exception() {
    data object NoInternetException : CoreException() {
        private fun readResolve(): Any = NoInternetException
    }

    data object TimeOutException : CoreException() {
        private fun readResolve(): Any = TimeOutException
    }

    data object UnauthorizedException : CoreException() {
        private fun readResolve(): Any = UnauthorizedException
    }

    data class UnknownException(var code: Int, var msg: String? = null) : CoreException()

    data object EmptyBodyResponseException : CoreException() {
        private fun readResolve(): Any = EmptyBodyResponseException
    }
}

/**
 * Specific error wrapper exception
 */
open class ResponseException(val error: ErrorResponse) : Exception()

fun generateExceptionByErrorCode(code: Int, message: String): Exception {
    return when (code) {
        in 200..300 -> CoreException.EmptyBodyResponseException
        401 -> CoreException.UnauthorizedException
        else -> CoreException.UnknownException(code = code, msg = message)
    }
}
