package com.vehiclecompanion.composables.buttons

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.vehiclecompanion.ext.noRippleClickable
import com.vehiclecompanion.presentation.R
import com.vehiclecompanion.theme.Theme

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = dimensionResource(id = R.dimen.small_radius),
    text: String,
    backgroundColor: Color = Theme.colors.secondary,
    @DrawableRes startIcon: Int? = null,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .background(if (enabled) backgroundColor else Theme.colors.disabled)
            .padding(dimensionResource(id = R.dimen.half_default_padding))
            .noRippleClickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            dimensionResource(id = R.dimen.small_padding),
            Alignment.CenterHorizontally
        )
    ) {
        if (startIcon != null) {
            Icon(
                modifier = Modifier.padding(end = dimensionResource(id = R.dimen.half_default_padding)),
                painter = painterResource(id = startIcon),
                tint = Theme.colors.background,
                contentDescription = null
            )
        }

        Text(
            text = text,
            color = if (enabled) {
                Theme.colors.primaryTextColor
            } else {
                Theme.colors.primaryDisabledTextColor
            },
            style = Theme.typography.bold14
        )
    }
}
