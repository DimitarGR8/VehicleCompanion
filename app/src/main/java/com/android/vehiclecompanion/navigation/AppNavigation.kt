package com.android.vehiclecompanion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vehiclecompanion.feature.HomeScreen
import com.vehiclecompanion.navigation.AppNavigator
import com.vehiclecompanion.navigation.NavigationRoutes

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = NavigationRoutes.HOME_SCREEN
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationRoutes.HOME_SCREEN) {
            HomeScreen(
                navigator = AppNavigator(navController)
            )
        }
    }
}
