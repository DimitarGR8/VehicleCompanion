package com.android.vehiclecompanion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import com.android.vehiclecompanion.presentation.MainActivityContent
import com.vehiclecompanion.events.EventBusViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private val eventBusViewModel: EventBusViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MainActivityContent(
                mainViewModel = mainViewModel,
                eventBusViewModel = eventBusViewModel
            )
        }
    }
}
