package com.vehiclecompanion.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

internal val LocalColors = staticCompositionLocalOf { Colors() }

@ConsistentCopyVisibility
data class Colors internal constructor(
    // Primary colors - Baby theme
    val primary: Color = coral,
    val primaryLight: Color = pink,
    val secondary: Color = darkBlue,

    // Background colors
    val background: Color = white,
    val backgroundSecondary: Color = lightBlue,
    val backgroundGrey: Color = lightBlue.copy(alpha = 0.3f),

    // State colors
    val error: Color = coral,
    val success: Color = darkBlue,
    val warning: Color = yellow,

    // Text colors
    val textFieldTextColor: Color = darkText,
    val primaryTextColor: Color = white,
    val primaryDisabledTextColor: Color = darkText.copy(alpha = 0.6f),
    val hintColor: Color = darkText.copy(alpha = 0.7f),

    // Border colors
    val borderColorFocused: Color = coral,
    val borderColorUnFocused: Color = lightBlue,
    val borderColorLight: Color = lightBlue.copy(alpha = 0.5f),
    val overlayTextFieldBorder: Color = darkText.copy(alpha = 0.1f),

    // Component specific colors
    val outlinedTextFieldColor: Color = lightBlue.copy(alpha = 0.8f),
    val disabled: Color = lightBlue.copy(alpha = 0.4f),
    val plateYellow: Color = yellow,

    // Baby-specific theme colors
    val babyLightBlue: Color = lightBlue,
    val babyDarkBlue: Color = darkBlue,
    val babyCoral: Color = coral,
    val babyPurple: Color = purple,
    val babyYellow: Color = yellow,
    val babyPink: Color = pink,
    val babyWhite: Color = white,
    val babyDarkText: Color = darkText
)

val lightBlue = Color(0xFFB8E6F0)
val darkBlue = Color(0xFF4A90A4)
val coral = Color(0xFFFF6B6B)
val purple = Color(0xFFD8A7E8)
val yellow = Color(0xFFFFF176)
val pink = Color(0xFFFFB3E6)
val white = Color.White
val darkText = Color(0xFF2D3748)
