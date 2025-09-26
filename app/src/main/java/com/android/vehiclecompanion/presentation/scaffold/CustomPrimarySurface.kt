package com.android.vehiclecompanion.presentation.scaffold

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.android.vehiclecompanion.navigation.AppNavHost
import com.vehiclecompanion.theme.Theme
import com.vehiclecompanion.theme.VehicleCompanionTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CustomPrimarySurface(
    navHostGraph: NavHostController
) {
    VehicleCompanionTheme {
        Scaffold(
            containerColor = Theme.colors.background,
            content = {
                AppNavHost(
                    navController = navHostGraph
                )
            }
        )
    }
}
