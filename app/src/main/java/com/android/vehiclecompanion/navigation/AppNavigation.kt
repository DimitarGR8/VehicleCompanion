package com.android.vehiclecompanion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.vehiclecompanion.navigation.NavigationRoutes

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = NavigationRoutes.INITIAL_SCREEN
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // Will set screen navigation here
    }
}
