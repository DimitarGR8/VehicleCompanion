package com.vehiclecompanion.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.vehiclecompanion.presentation.R

val gothamBold = FontFamily(
    Font(R.font.gotham_bold)
)

val gothamMedium = FontFamily(
    Font(R.font.gotham_medium)
)

val gothamLight = FontFamily(
    Font(R.font.gotham_light)
)

val gothamRegular = FontFamily(
    Font(R.font.gotham_regular)
)

internal val LocalTypography = staticCompositionLocalOf { Typography() }

@ConsistentCopyVisibility
data class Typography internal constructor(
    val light12: TextStyle = TextStyle(
        fontSize = 12.sp,
        fontFamily = gothamLight,
        lineHeight = DEFAULT_LINE_HEIGHT.sp
    ),
    val light13: TextStyle = TextStyle(
        fontSize = 13.sp,
        fontFamily = gothamLight,
        lineHeight = DEFAULT_LINE_HEIGHT.sp
    ),
    val light14: TextStyle = TextStyle(
        fontSize = 14.sp,
        fontFamily = gothamLight,
        lineHeight = DEFAULT_LINE_HEIGHT.sp
    ),
    val regular12: TextStyle = TextStyle(
        fontSize = 12.sp,
        fontFamily = gothamRegular,
        lineHeight = DEFAULT_LINE_HEIGHT.sp

    ),
    val regular13: TextStyle = TextStyle(
        fontSize = 13.sp,
        fontFamily = gothamRegular,
        lineHeight = DEFAULT_LINE_HEIGHT.sp
    ),
    val regular14: TextStyle = TextStyle(
        fontSize = 14.sp,
        fontFamily = gothamRegular,
        lineHeight = DEFAULT_LINE_HEIGHT.sp
    ),
    val regular16: TextStyle = TextStyle(
        fontSize = 16.sp,
        fontFamily = gothamRegular,
        lineHeight = DEFAULT_LINE_HEIGHT.sp
    ),
    val bold12: TextStyle = TextStyle(
        fontSize = 12.sp,
        fontFamily = gothamBold,
        lineHeight = DEFAULT_LINE_HEIGHT.sp
    ),
    val bold14: TextStyle = TextStyle(
        fontSize = 14.sp,
        fontFamily = gothamBold,
        lineHeight = DEFAULT_LINE_HEIGHT.sp
    ),
    val bold20: TextStyle = TextStyle(
        fontSize = 20.sp,
        fontFamily = gothamBold,
        lineHeight = DEFAULT_LINE_HEIGHT.sp
    ),
    val bold24: TextStyle = TextStyle(
        fontSize = 24.sp,
        fontFamily = gothamBold,
        lineHeight = DEFAULT_LINE_HEIGHT.sp
    ),
    val bold32: TextStyle = TextStyle(
        fontSize = 32.sp,
        fontFamily = gothamBold,
        lineHeight = DEFAULT_LINE_HEIGHT.sp
    ),
    val bold60: TextStyle = TextStyle(
        fontSize = 60.sp,
        fontFamily = gothamBold,
        lineHeight = 60.sp
    ),
    val bold16: TextStyle = TextStyle(
        fontSize = 16.sp,
        fontFamily = gothamBold,
        lineHeight = DEFAULT_LINE_HEIGHT.sp
    ),
    val bold18: TextStyle = TextStyle(
        fontSize = 18.sp,
        fontFamily = gothamBold,
        lineHeight = DEFAULT_LINE_HEIGHT.sp
    ),
    val medium10: TextStyle = TextStyle(
        fontSize = 10.sp,
        fontFamily = gothamMedium,
        lineHeight = DEFAULT_LINE_HEIGHT.sp
    ),
    val medium12: TextStyle = TextStyle(
        fontSize = 12.sp,
        fontFamily = gothamMedium,
        lineHeight = DEFAULT_LINE_HEIGHT.sp
    ),
    val medium14: TextStyle = TextStyle(
        fontSize = 14.sp,
        fontFamily = gothamMedium,
        lineHeight = DEFAULT_LINE_HEIGHT.sp
    )
) {
    companion object {
        private const val DEFAULT_LINE_HEIGHT = 22
    }
}
