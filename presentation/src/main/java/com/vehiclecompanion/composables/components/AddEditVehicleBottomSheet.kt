package com.vehiclecompanion.composables.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.vehiclecompanion.composables.buttons.PrimaryButton
import com.vehiclecompanion.composables.textfields.CustomTextField
import com.vehiclecompanion.composables.textfields.TextFieldTypes
import com.vehiclecompanion.presentation.R
import com.vehiclecompanion.theme.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditVehicleBottomSheet(
    name: String,
    make: String,
    model: String,
    year: String,
    vin: String,
    fuelType: String,
    imageUri: String,
    title: String,
    isValid: Boolean,
    onDismiss: () -> Unit,
    onSave: () -> Unit,
    onNameChange: (String) -> Unit,
    onMakeChange: (String) -> Unit,
    onModelChange: (String) -> Unit,
    onYearChange: (String) -> Unit,
    onVinChange: (String) -> Unit,
    onFuelTypeChange: (String) -> Unit,
    onImageChange: (String) -> Unit
) {
    CustomBottomSheet(
        onDismiss = onDismiss,
        maxHeightFraction = 0.8f,
        enableScroll = true
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall
            )

            IconButton(onClick = onDismiss) {
                Icon(
                    painterResource(R.drawable.ic_close),
                    contentDescription = stringResource(R.string.close)
                )
            }
        }

        Spacer(modifier = Modifier.height(Dimens.defaultPadding))

        // Form Content
        VehicleFormContent(
            name = name,
            make = make,
            model = model,
            year = year,
            vin = vin,
            fuelType = fuelType,
            imageUri = imageUri,
            onNameChange = onNameChange,
            onMakeChange = onMakeChange,
            onModelChange = onModelChange,
            onYearChange = onYearChange,
            onVinChange = onVinChange,
            onFuelTypeChange = onFuelTypeChange,
            onImageChange = onImageChange
        )

        Spacer(modifier = Modifier.height(Dimens.defaultPadding))

        // Action Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                Dimens.halfDefaultPadding,
                Alignment.End
            )
        ) {
            TextButton(onClick = onDismiss) {
                Text(stringResource(R.string.cancel))
            }

            PrimaryButton(
                text = stringResource(R.string.save),
                onClick = onSave,
                enabled = isValid,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(Dimens.defaultPadding))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun VehicleFormContent(
    name: String,
    make: String,
    model: String,
    year: String,
    vin: String,
    fuelType: String,
    imageUri: String,
    onNameChange: (String) -> Unit,
    onMakeChange: (String) -> Unit,
    onModelChange: (String) -> Unit,
    onYearChange: (String) -> Unit,
    onVinChange: (String) -> Unit,
    onFuelTypeChange: (String) -> Unit,
    onImageChange: (String) -> Unit
) {
    val fuelTypes = listOf("Gasoline", "Diesel", "Electric", "Hybrid", "Plug-in Hybrid")
    var expandedFuelType by remember { mutableStateOf(false) }

    CustomTextField(
        text = name,
        hint = stringResource(R.string.vehicle_name_hint),
        onTextChange = onNameChange,
        modifier = Modifier.fillMaxWidth(),
        textFieldTypes = TextFieldTypes.DEFAULT
    )

    Spacer(modifier = Modifier.height(Dimens.defaultPadding))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Dimens.halfDefaultPadding)
    ) {
        CustomTextField(
            text = make,
            hint = stringResource(R.string.make_hint),
            onTextChange = onMakeChange,
            modifier = Modifier.weight(1f),
            textFieldTypes = TextFieldTypes.DEFAULT
        )

        CustomTextField(
            text = model,
            hint = stringResource(R.string.model_hint),
            onTextChange = onModelChange,
            modifier = Modifier.weight(1f),
            textFieldTypes = TextFieldTypes.DEFAULT
        )
    }

    Spacer(modifier = Modifier.height(Dimens.defaultPadding))

    CustomTextField(
        text = year,
        hint = stringResource(R.string.year_hint),
        onTextChange = onYearChange,
        modifier = Modifier.fillMaxWidth(),
        textFieldTypes = TextFieldTypes.DEFAULT
    )

    Spacer(modifier = Modifier.height(Dimens.defaultPadding))

    ExposedDropdownMenuBox(
        expanded = expandedFuelType,
        onExpandedChange = { expandedFuelType = it }
    ) {
        OutlinedTextField(
            value = fuelType,
            onValueChange = { },
            readOnly = true,
            label = { Text(stringResource(R.string.fuel_type_label)) },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(),
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expandedFuelType) }
        )

        ExposedDropdownMenu(
            expanded = expandedFuelType,
            onDismissRequest = { expandedFuelType = false }
        ) {
            fuelTypes.forEach { fuelType ->
                DropdownMenuItem(
                    text = { Text(fuelType) },
                    onClick = {
                        onFuelTypeChange(fuelType)
                        expandedFuelType = false
                    }
                )
            }
        }
    }

    Spacer(modifier = Modifier.height(Dimens.defaultPadding))

    CustomTextField(
        text = vin,
        hint = stringResource(R.string.vin_hint),
        onTextChange = onVinChange,
        modifier = Modifier.fillMaxWidth(),
        textFieldTypes = TextFieldTypes.ADD_VEHICLE_NUMBER
    )

    Spacer(modifier = Modifier.height(Dimens.defaultPadding))

    ImagePickerButton(
        imageUri = imageUri.takeIf { it.isNotEmpty() },
        onImageSelected = onImageChange,
        modifier = Modifier.fillMaxWidth()
    )
}
