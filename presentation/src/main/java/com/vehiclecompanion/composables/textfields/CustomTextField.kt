package com.vehiclecompanion.composables.textfields

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults.Container
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.vehiclecompanion.presentation.R
import com.vehiclecompanion.theme.Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    text: String,
    hint: String,
    enabled: Boolean = true,
    onErrorText: String = "",
    isError: Boolean = false,
    textFieldTypes: TextFieldTypes,
    onTextChange: (text: String) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    var newText by remember { mutableStateOf(text) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.small_padding))
    ) {
        BasicTextField(
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.text_field_height))
                .fillMaxWidth()
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.medium_radius)))
                .background(Theme.colors.background),
            enabled = enabled,
            value = text,
            singleLine = true,
            cursorBrush = SolidColor(Theme.colors.primary),
            textStyle = Theme.typography.regular13,
            visualTransformation = textFieldTypes.visualTransformation,
            interactionSource = interactionSource,
            keyboardOptions = KeyboardOptions(
                keyboardType = textFieldTypes.keyboardType,
                imeAction = textFieldTypes.imeAction,
                capitalization = textFieldTypes.capitalization
            ),
            onValueChange = {
                if (it.matches(textFieldTypes.regexPattern)) {
                    newText = it
                    onTextChange(newText)
                }
            }
        ) { innerTextField ->
            OutlinedTextFieldDefaults.DecorationBox(
                value = text,
                innerTextField = innerTextField,
                enabled = true,
                singleLine = true,
                interactionSource = interactionSource,
                visualTransformation = VisualTransformation.None,
                placeholder = {
                    Text(
                        text = hint,
                        style = Theme.typography.regular13,
                        color = Theme.colors.hintColor
                    )
                },
                container = {
                    Container(
                        enabled = true,
                        isError = isError,
                        interactionSource = interactionSource,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Theme.colors.textFieldTextColor,
                            unfocusedTextColor = Theme.colors.textFieldTextColor,
                            unfocusedBorderColor = if (isError) Theme.colors.error else Theme.colors.overlayTextFieldBorder,
                            focusedBorderColor = if (isError) Theme.colors.error else Theme.colors.primary
                        ),
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.medium_radius)),
                        focusedBorderThickness = 1.dp,
                        unfocusedBorderThickness = 1.dp,
                    )
                }
            )
        }

        if (isError) {
            Text(
                text = onErrorText,
                color = Theme.colors.error,
                style = Theme.typography.regular12
            )
        }
    }
}
