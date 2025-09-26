package com.vehiclecompanion.composables.buttons

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.vehiclecompanion.ext.noRippleClickable
import com.vehiclecompanion.presentation.R
import com.vehiclecompanion.theme.Theme

@Composable
fun RoundedCornerButton(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    iconTint: Color = Theme.colors.primary,
    backGroundColor: Color = Theme.colors.backgroundSecondary,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .background(
                color = backGroundColor,
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.rounded_corner))
            )
            .padding(dimensionResource(id = R.dimen.rounded_corner))
            .aspectRatio(1F)
            .noRippleClickable {
                if (enabled) {
                    onClick()
                }
            }
    ) {
        Icon(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = icon),
            tint = iconTint,
            contentDescription = null
        )
    }
}
