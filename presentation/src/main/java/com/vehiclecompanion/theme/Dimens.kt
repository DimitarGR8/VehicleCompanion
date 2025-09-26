package com.vehiclecompanion.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import com.vehiclecompanion.presentation.R

object Dimens {
    val largePadding: Dp @Composable get() = dimensionResource(R.dimen.large_padding)
    val doubleDefaultPadding: Dp @Composable get() = dimensionResource(R.dimen.double_default_padding)
    val defaultPadding: Dp @Composable get() = dimensionResource(R.dimen.default_padding)
    val halfDefaultPadding: Dp @Composable get() = dimensionResource(R.dimen.half_default_padding)
    val smallPadding: Dp @Composable get() = dimensionResource(R.dimen.small_padding)

    val smallRadius: Dp @Composable get() = dimensionResource(R.dimen.small_radius)
    val mediumRadius: Dp @Composable get() = dimensionResource(R.dimen.medium_radius)
    val bigRadius: Dp @Composable get() = dimensionResource(R.dimen.big_radius)
    val roundedCorner: Dp @Composable get() = dimensionResource(R.dimen.rounded_corner)

    val dialogCloseButtonBorderWidth: Dp @Composable get() = dimensionResource(R.dimen.dialog_close_button_border_width)
    val dialogCloseButtonWidth: Dp @Composable get() = dimensionResource(R.dimen.dialog_close_button_width)
    val dialogActionButtonHeight: Dp @Composable get() = dimensionResource(R.dimen.dialog_action_button_height)
    val loaderProgressIndicatorWidth: Dp @Composable get() = dimensionResource(R.dimen.loader_progress_indicator_width)
}
