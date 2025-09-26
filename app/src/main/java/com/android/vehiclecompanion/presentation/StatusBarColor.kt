package com.android.vehiclecompanion.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlin.apply

@Composable
internal fun StatusBarColor(statusLightIcons: Boolean) {
    val systemUiController = rememberSystemUiController()

    systemUiController.apply {
        setStatusBarColor(color = Color.Transparent, darkIcons = !statusLightIcons)
        setNavigationBarColor(color = Color.Black, darkIcons = false)
    }
}
