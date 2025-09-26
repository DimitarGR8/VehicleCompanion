package com.vehiclecompanion.composables.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.vehiclecompanion.composables.buttons.PrimaryButton
import com.vehiclecompanion.theme.Dimens
import com.vehiclecompanion.theme.Theme

@Composable
fun EmptyState(
    @DrawableRes iconRes: Int,
    title: String,
    subtitle: String,
    actionText: String? = null,
    onActionClick: () -> Unit = {},
    noButton: Boolean = false,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = null,
            modifier = Modifier.size(120.dp),
            tint = Theme.colors.hintColor.copy(alpha = 0.6f)
        )

        Spacer(modifier = Modifier.height(Dimens.defaultPadding))

        Text(
            text = title,
            style = Theme.typography.bold20,
            color = Theme.colors.hintColor,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(Dimens.halfDefaultPadding))

        Text(
            text = subtitle,
            style = Theme.typography.regular14,
            color = Theme.colors.hintColor.copy(alpha = 0.8f),
            textAlign = TextAlign.Center
        )

        if (!noButton) {
            Spacer(modifier = Modifier.height(Dimens.doubleDefaultPadding))

            PrimaryButton(
                text = actionText ?: "",
                onClick = onActionClick,
                modifier = Modifier.padding(horizontal = Dimens.doubleDefaultPadding)
            )
        }
    }
}
