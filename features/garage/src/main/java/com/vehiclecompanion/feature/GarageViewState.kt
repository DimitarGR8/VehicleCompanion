package com.vehiclecompanion.feature

import com.vehiclecompanion.model.VehicleModel

data class GarageViewState(
    val vehicles: List<VehicleModel> = emptyList(),
    val showAddVehicleDialog: Boolean = false,
    val showEditVehicleDialog: Boolean = false,
    val editingVehicle: VehicleModel? = null,
    val vehicleForm: VehicleFormState = VehicleFormState()
)

data class VehicleFormState(
    val name: String = "",
    val make: String = "",
    val model: String = "",
    val year: String = "",
    val vin: String = "",
    val fuelType: String = "",
    val imageUri: String = ""
) {
    val isValid: Boolean
        get() = name.isNotBlank() &&
            make.isNotBlank() &&
            model.isNotBlank() &&
            year.isNotBlank() &&
            fuelType.isNotBlank()

    fun toVehicleModel(id: Long = 0): VehicleModel {
        return VehicleModel(
            id = id,
            name = name.trim(),
            make = make.trim(),
            model = model.trim(),
            year = year.toIntOrNull() ?: 0,
            vin = vin.trim().takeIf { it.isNotBlank() },
            fuelType = fuelType.trim(),
            imageUri = imageUri.takeIf { it.isNotBlank() }
        )
    }
}
