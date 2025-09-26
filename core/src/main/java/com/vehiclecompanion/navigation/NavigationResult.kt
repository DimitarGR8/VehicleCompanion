package com.happywebsocketbirthday.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController

object NavigationResult {
    object Keys {
        const val CAMERA_RESULT = "camera_result"
    }

    fun <T> setResult(navController: NavController, key: String, result: T) {
        navController.previousBackStackEntry?.savedStateHandle?.set(key, result)
    }

    fun <T> getResult(savedStateHandle: SavedStateHandle, key: String): T? {
        return savedStateHandle.get<T>(key)
    }

    fun clearResult(savedStateHandle: SavedStateHandle, key: String) {
        savedStateHandle.remove<Any>(key)
    }

    fun <T> observeResult(
        savedStateHandle: SavedStateHandle,
        key: String,
        onResult: (T) -> Unit
    ) {
        val result = savedStateHandle.get<T>(key)
        if (result != null) {
            onResult(result)
            savedStateHandle.remove<Any>(key)
        }
    }
}
