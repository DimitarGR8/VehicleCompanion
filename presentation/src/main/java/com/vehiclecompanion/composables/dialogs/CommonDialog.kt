package com.vehiclecompanion.composables.dialogs

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.DialogProperties
import com.vehiclecompanion.composables.buttons.RoundedCornerButton
import com.vehiclecompanion.composables.buttons.SecondaryButton
import com.vehiclecompanion.presentation.R
import com.vehiclecompanion.theme.Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonDialog(
    @StringRes titleRes: Int,
    @StringRes subTitleRes: Int,
    titleString: String?,
    subTitleString: String?,
    @StringRes buttonTextRes: Int,
    isErrorDialog: Boolean = false,
    onDismiss: () -> Unit,
    onAction: () -> Unit
) {
    BasicAlertDialog(
        onDismissRequest = {
            onDismiss()
        },
        modifier = Modifier
            .padding(horizontal = dimensionResource(id = R.dimen.default_padding))
            .clip(shape = RoundedCornerShape(dimensionResource(id = R.dimen.big_radius)))
            .background(Theme.colors.background),
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.default_padding))
                .padding(start = dimensionResource(id = R.dimen.default_padding)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.default_padding))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = if (titleString.isNullOrEmpty()) stringResource(id = titleRes) else titleString,
                    style = Theme.typography.bold16,
                    color = if (!isErrorDialog) Theme.colors.textFieldTextColor else Theme.colors.error,
                )

                RoundedCornerButton(
                    modifier = Modifier
                        .border(
                            width = dimensionResource(R.dimen.dialog_close_button_border_width),
                            color = Theme.colors.primaryDisabledTextColor,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.small_radius))
                        )
                        .padding(dimensionResource(id = R.dimen.half_default_padding))
                        .width(dimensionResource(R.dimen.dialog_close_button_width)),
                    icon = R.drawable.ic_x,
                    iconTint = Theme.colors.hintColor,
                    backGroundColor = Color.Transparent
                ) {
                    onDismiss()
                }
            }

            Text(
                modifier = Modifier.padding(end = dimensionResource(id = R.dimen.default_padding)),
                text = if (subTitleString.isNullOrEmpty()) stringResource(id = subTitleRes) else subTitleString,
                color = Theme.colors.hintColor,
                style = Theme.typography.regular16
            )

            SecondaryButton(
                modifier = Modifier
                    .padding(end = dimensionResource(id = R.dimen.default_padding))
                    .padding(top = dimensionResource(id = R.dimen.default_padding))
                    .fillMaxWidth()
                    .height(dimensionResource(R.dimen.dialog_action_button_height)),
                text = stringResource(id = buttonTextRes),
                backgroundColor = if (!isErrorDialog) Theme.colors.secondary else Theme.colors.error,
                cornerRadius = dimensionResource(id = R.dimen.medium_radius)
            ) {
                onAction()
            }
        }
    }
}
