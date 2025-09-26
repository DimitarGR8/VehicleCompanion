package com.happywebsocketbirthday.navigation

import com.google.gson.Gson
import java.net.URLDecoder
import java.net.URLEncoder

/**
 * Utility for handling complex object navigation arguments
 */
object NavigationArguments {

    val gson = Gson()

    /**
     * Encode an object to a URL-safe string for navigation
     */
    inline fun <reified T> encodeArgument(obj: T): String {
        val json = gson.toJson(obj)
        return URLEncoder.encode(json, "UTF-8")
    }

    /**
     * Decode a URL-safe string back to an object
     */
    inline fun <reified T> decodeArgument(encodedString: String, clazz: Class<T>): T? {
        return try {
            val json = URLDecoder.decode(encodedString, "UTF-8")
            gson.fromJson(json, clazz)
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Create a route with encoded object argument
     */
    fun createRouteWithObjectArg(baseRoute: String, argName: String, obj: Any): String {
        val encodedArg = encodeArgument(obj)
        return "$baseRoute?$argName=$encodedArg"
    }

    /**
     * Extract object argument from navigation arguments
     */
    inline fun <reified T> extractObjectArg(
        arguments: Map<String, String>?,
        argName: String,
        clazz: Class<T>
    ): T? {
        val encodedArg = arguments?.get(argName) ?: return null
        return decodeArgument(encodedArg, clazz)
    }
}
