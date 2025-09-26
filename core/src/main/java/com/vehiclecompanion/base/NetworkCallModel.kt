package com.vehiclecompanion.base

data class NetworkCallModel(
    var call: suspend () -> Any,
    var onSuccess: suspend (Any) -> Unit,
    var onError: suspend (ErrorResponse?) -> Unit = {},
    var onSuccessWithNoResult: suspend () -> Unit = {},
    var withLoader: Boolean = true
)
