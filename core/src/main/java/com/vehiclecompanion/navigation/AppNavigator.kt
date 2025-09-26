package com.vehiclecompanion.navigation

import androidx.navigation.NavController

class AppNavigator(
    internal val navController: NavController
) {
    fun navigateUp() {
        navController.navigateUp()
    }

    fun popBackStack() {
        navController.popBackStack()
    }

    fun executeNavigation(
        route: String,
        addToBackstack: Boolean = true,
        previousScreen: String? = null,
        clearEntireBackstack: Boolean = false
    ) {
        navController.navigate(route) {
            if (!addToBackstack) {
                if (clearEntireBackstack) {
                    popUpTo(0) { inclusive = true }
                } else {
                    previousScreen?.let { previousRoute ->
                        popUpTo(previousRoute) {
                            inclusive = true
                        }
                    }
                }
            }
            launchSingleTop = true
        }
    }

    fun navigateBackWithResult(key: String, result: Any) {
        NavigationResult.setResult(navController, key, result)
        navigateUp()
    }

    fun navigateBackWithImageResult(imageUri: String) {
        navigateBackWithResult(NavigationResult.Keys.CAMERA_RESULT, imageUri)
    }
}
