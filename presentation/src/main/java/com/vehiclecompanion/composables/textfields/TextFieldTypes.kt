package com.vehiclecompanion.composables.textfields

import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

enum class TextFieldTypes(
    val regexPattern: Regex = Regex("^[A-Za-z\\p{N}\\p{P}+]*\$"),
    val visualTransformation: VisualTransformation = VisualTransformation.None,
    val imeAction: ImeAction = ImeAction.Done,
    val capitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    val keyboardType: KeyboardType = KeyboardType.Text
) {
    DEFAULT,
    LOGIN_USERNAME(
        imeAction = ImeAction.Next
    ),
    LOGIN_PASSWORD(
        keyboardType = KeyboardType.Password,
        visualTransformation = PasswordVisualTransformation()
    ),
    TOGGLE_EMAIL(
        keyboardType = KeyboardType.Email
    ),
    PASSWORD(
        regexPattern = Regex("^[a-zA-Z0-9 !@#\$%^&*()_+-=\\[\\]{}|;:'\",.<>?/]*$"),
        keyboardType = KeyboardType.Password,
        imeAction = ImeAction.Next,
        visualTransformation = PasswordVisualTransformation()
    ),
    CONFIRM_PASSWORD(
        regexPattern = Regex("^[a-zA-Z0-9 !@#\$%^&*()_+-=\\[\\]{}|;:'\",.<>?/]*$"),
        keyboardType = KeyboardType.Password,
        visualTransformation = PasswordVisualTransformation()
    ),
    CARD_NUMBER(
        regexPattern = Regex("^[0-9]*$"),
        keyboardType = KeyboardType.Number,
        visualTransformation = CardNumberFormatter.toVisualTransformation()
    ),
    CARD_EXPIRY_NUMBER(
        regexPattern = Regex("^[0-9]*$"),
        keyboardType = KeyboardType.Number,
        visualTransformation = MMYYFormatter.toVisualTransformation()
    ),
    CVV_NUMBER(
        regexPattern = Regex("^[0-9]*$"),
        keyboardType = KeyboardType.Number,
        visualTransformation = CVVFormatter.toVisualTransformation()
    ),
    ADD_VEHICLE_NUMBER(
        regexPattern = Regex("^[A-Z0-9]{0,12}$"),
        capitalization = KeyboardCapitalization.Characters
    )
}
