package com.vehiclecompanion.feature

import com.vehiclecompanion.base.BaseAction
import com.vehiclecompanion.model.VehicleModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

sealed interface GarageAction : BaseAction<GarageViewState> {
    data object ShowAddVehicleDialog : GarageAction {
        override fun updateData(previousData: MutableStateFlow<GarageViewState>) {
            previousData.update {
                it.copy(
                    showAddVehicleDialog = true,
                    vehicleForm = VehicleFormState()
                )
            }
        }
    }

    data object HideAddVehicleDialog : GarageAction {
        override fun updateData(previousData: MutableStateFlow<GarageViewState>) {
            previousData.update {
                it.copy(
                    showAddVehicleDialog = false,
                    vehicleForm = VehicleFormState()
                )
            }
        }
    }

    data class ShowEditVehicleDialog(val vehicle: VehicleModel) : GarageAction {
        override fun updateData(previousData: MutableStateFlow<GarageViewState>) {
            previousData.update {
                it.copy(
                    showEditVehicleDialog = true,
                    editingVehicle = vehicle,
                    vehicleForm = vehicle.toFormState()
                )
            }
        }
    }

    data object HideEditVehicleDialog : GarageAction {
        override fun updateData(previousData: MutableStateFlow<GarageViewState>) {
            previousData.update {
                it.copy(
                    showEditVehicleDialog = false,
                    editingVehicle = null,
                    vehicleForm = VehicleFormState()
                )
            }
        }
    }

    data class VehiclesLoaded(val vehicles: List<VehicleModel>) : GarageAction {
        override fun updateData(previousData: MutableStateFlow<GarageViewState>) {
            previousData.update {
                it.copy(vehicles = vehicles)
            }
        }
    }

    data class DeleteVehicle(val vehicleId: Long) : GarageAction
    data class SaveVehicle(val vehicle: VehicleModel) : GarageAction

    data class UpdateVehicleName(val name: String) : GarageAction {
        override fun updateData(previousData: MutableStateFlow<GarageViewState>) {
            previousData.update {
                it.copy(
                    vehicleForm = it.vehicleForm.copy(name = name)
                )
            }
        }
    }

    data class UpdateVehicleMake(val make: String) : GarageAction {
        override fun updateData(previousData: MutableStateFlow<GarageViewState>) {
            previousData.update {
                it.copy(
                    vehicleForm = it.vehicleForm.copy(make = make)
                )
            }
        }
    }

    data class UpdateVehicleModel(val model: String) : GarageAction {
        override fun updateData(previousData: MutableStateFlow<GarageViewState>) {
            previousData.update {
                it.copy(
                    vehicleForm = it.vehicleForm.copy(model = model)
                )
            }
        }
    }

    data class UpdateVehicleYear(val year: String) : GarageAction {
        override fun updateData(previousData: MutableStateFlow<GarageViewState>) {
            previousData.update {
                it.copy(
                    vehicleForm = it.vehicleForm.copy(year = year)
                )
            }
        }
    }

    data class UpdateVehicleVin(val vin: String) : GarageAction {
        override fun updateData(previousData: MutableStateFlow<GarageViewState>) {
            previousData.update {
                it.copy(
                    vehicleForm = it.vehicleForm.copy(vin = vin)
                )
            }
        }
    }

    data class UpdateVehicleFuelType(val fuelType: String) : GarageAction {
        override fun updateData(previousData: MutableStateFlow<GarageViewState>) {
            previousData.update {
                it.copy(
                    vehicleForm = it.vehicleForm.copy(fuelType = fuelType)
                )
            }
        }
    }

    data class UpdateVehicleImage(val imageUri: String) : GarageAction {
        override fun updateData(previousData: MutableStateFlow<GarageViewState>) {
            previousData.update {
                it.copy(
                    vehicleForm = it.vehicleForm.copy(imageUri = imageUri)
                )
            }
        }
    }
}

private fun VehicleModel.toFormState(): VehicleFormState {
    return VehicleFormState(
        name = name,
        make = make,
        model = model,
        year = year.toString(),
        vin = vin ?: "",
        fuelType = fuelType,
        imageUri = imageUri ?: ""
    )
}
