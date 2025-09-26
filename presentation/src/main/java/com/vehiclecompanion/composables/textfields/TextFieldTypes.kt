package com.vehiclecompanion.composables.textfields

import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

enum class TextFieldTypes(
    val regexPattern: Regex = Regex("^[A-Za-z\\p{N}\\p{P}+]*\$"),
    val visualTransformation: VisualTransformation = VisualTransformation.None,
    val imeAction: ImeAction = ImeAction.Done,
    val capitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    val keyboardType: KeyboardType = KeyboardType.Text
) {
    DEFAULT,
    ADD_VEHICLE_NUMBER(
        regexPattern = Regex("^[A-Z0-9]{0,12}$"),
        capitalization = KeyboardCapitalization.Characters
    ),
    VEHICLE_YEAR(
        regexPattern = Regex("^[0-9]{0,4}$"),
        keyboardType = KeyboardType.Number,
        imeAction = ImeAction.Next
    )
}
