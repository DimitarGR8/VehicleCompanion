package com.vehiclecompanion.feature

import com.vehiclecompanion.base.BaseAction
import com.vehiclecompanion.model.VehicleModel

sealed interface GarageAction : BaseAction<GarageViewState> {
    data object ShowAddVehicleDialog : GarageAction
    data object HideAddVehicleDialog : GarageAction
    data class ShowEditVehicleDialog(val vehicle: VehicleModel) : GarageAction
    data object HideEditVehicleDialog : GarageAction
    data class DeleteVehicle(val vehicleId: Long) : GarageAction
    data class SaveVehicle(val vehicle: VehicleModel) : GarageAction
    data class UpdateVehicleName(val name: String) : GarageAction
    data class UpdateVehicleMake(val make: String) : GarageAction
    data class UpdateVehicleModel(val model: String) : GarageAction
    data class UpdateVehicleYear(val year: String) : GarageAction
    data class UpdateVehicleVin(val vin: String) : GarageAction
    data class UpdateVehicleFuelType(val fuelType: String) : GarageAction
    data class UpdateVehicleImage(val imageUri: String) : GarageAction
}
