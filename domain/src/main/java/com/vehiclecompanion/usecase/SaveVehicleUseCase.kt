package com.vehiclecompanion.usecase

import com.vehiclecompanion.model.VehicleModel
import com.vehiclecompanion.repository.VehicleRepository
import javax.inject.Inject

class SaveVehicleUseCase @Inject constructor(
    private val vehicleRepository: VehicleRepository
) {
    suspend operator fun invoke(vehicle: VehicleModel): Long {
        return if (vehicle.id == 0L) {
            vehicleRepository.insertVehicle(vehicle)
        } else {
            vehicleRepository.updateVehicle(vehicle)
            vehicle.id
        }
    }
}
