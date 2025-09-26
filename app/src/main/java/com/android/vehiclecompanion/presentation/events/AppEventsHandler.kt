package com.android.vehiclecompanion.presentation.events

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.vehiclecompanion.composables.dialogs.LoaderDialog
import com.vehiclecompanion.events.EventsViewState

@Composable
fun AppEventsHandler(
    events: EventsViewState,
    switchSystemBarColors: (Boolean) -> Unit
) {
    var loaderState by remember {
        mutableStateOf(false)
    }

    // Events
    LaunchedEffect(events) {
        with(events) {
            switchStatusIconColor.peekValue()?.let {
                switchSystemBarColors(it.lightIcons)
            }

            showLoader.peekValue()?.let {
                loaderState = it
            }
        }
    }

    if (loaderState) {
        LoaderDialog()
    }
}
