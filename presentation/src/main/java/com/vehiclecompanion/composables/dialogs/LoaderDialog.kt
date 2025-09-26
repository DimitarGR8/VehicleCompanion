package com.vehiclecompanion.composables.dialogs

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.vehiclecompanion.composables.components.LoadingState

@Composable
fun LoaderDialog() {
    Dialog(
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = false
        ),
        onDismissRequest = {}
    ) {
        LoadingState()
    }
}
