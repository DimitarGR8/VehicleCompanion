package com.vehiclecompanion.theme

import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.vehiclecompanion.theme.Theme.customTextSelectionColors

object Theme {
    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val customTextSelectionColors: TextSelectionColors = TextSelectionColors(
        handleColor = primary_orange,
        backgroundColor = primary_orange.copy(alpha = 0.4f)
    )
}

@Composable
fun VehicleCompanionTheme(
    typography: Typography = Theme.typography,
    theme: Colors = Theme.colors,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalTypography provides typography,
        LocalColors provides theme,
        LocalTextSelectionColors provides customTextSelectionColors
    ) {
        content()
    }
}
