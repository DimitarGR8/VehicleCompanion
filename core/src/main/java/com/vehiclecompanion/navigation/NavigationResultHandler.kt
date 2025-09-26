package com.happywebsocketbirthday.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavigationResultHandler(
    navigator: AppNavigator,
    onCameraResult: ((String) -> Unit)? = null
) {
    val currentBackStackEntry = navigator.navController.currentBackStackEntryAsState()
    val savedStateHandle = currentBackStackEntry.value?.savedStateHandle

    LaunchedEffect(currentBackStackEntry.value) {
        savedStateHandle?.let { handle ->
            onCameraResult?.let { callback ->
                NavigationResult.observeResult<String>(
                    savedStateHandle = handle,
                    key = NavigationResult.Keys.CAMERA_RESULT,
                    onResult = callback
                )
            }
        }
    }
}
