package com.happywebsocketbirthday.base

import com.google.gson.annotations.SerializedName

/**
 * Abstract Network Error Response type
 */
abstract class ErrorResponse {
    open var errorCode: Int? = null
    open var errorMessage: String? = null
}

/**
 * Used for calls that does not have specific error response type
 */
object NoError : ErrorResponse()

/**
 * Any error that has not been handled
 */
class UnknownError(override var errorCode: Int?, override var errorMessage: String?) :
    ErrorResponse()

class DefaultError(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("code")
    val code: Int? = null,
    @SerializedName("message")
    val message: String? = null
) : ErrorResponse()
