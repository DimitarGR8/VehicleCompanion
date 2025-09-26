package com.vehiclecompanion.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

internal val LocalColors = staticCompositionLocalOf { Colors() }

@ConsistentCopyVisibility
data class Colors internal constructor(
    val primary: Color = primary_orange,
    val primaryLight: Color = primary_orange_light,
    val secondary: Color = primary_teal,
    val background: Color = Color.White,
    val backgroundSecondary: Color = light_orange_background,
    val backgroundGrey: Color = primary_grey_background,
    val error: Color = primary_red,
    val textFieldTextColor: Color = primary_black,
    val disabled: Color = primary_disabled,
    val hintColor: Color = primary_grey,
    val primaryTextColor: Color = white,
    val primaryDisabledTextColor: Color = disabled_grey,
    val borderColorFocused: Color = primary_orange,
    val borderColorUnFocused: Color = light_grey_border,
    val outlinedTextFieldColor: Color = light_grey,
    val borderColorLight: Color = light_grey_border,
    val overlayTextFieldBorder: Color = primary_black.copy(0.1f),
    val plateYellow: Color = dark_yellow
)

val primary_orange = Color(0xFFF78D2B)
val primary_orange_light = Color(0xFFFCDCBF)
val primary_teal = Color(0xFF0098A6)
val primary_red = Color(0xFFA91D54)
val primary_black = Color(0xFF181818)
val light_orange_background = Color(0xFFFDE8D5)
val primary_grey_background = Color(0xFFEFEEEE)
val primary_disabled = Color(0xFFE8E8E8)
val primary_grey = Color(0xFF807F83)
val white = Color(0xFFFFFFFF)
val disabled_grey = Color(0xFFB9B9B9)
val overlay_grey = Color(0xB2181818)
val border_grey = Color(0x66000000)
val light_grey = Color(0xFFD0CFCD)
val light_grey_border = Color(0x1A181818)
val dark_yellow = Color(0xFFFFCD26)
