package com.vehiclecompanion.usecase

import com.vehiclecompanion.repository.VehicleRepository
import javax.inject.Inject

class DeleteVehicleUseCase @Inject constructor(
    private val vehicleRepository: VehicleRepository
) {
    suspend operator fun invoke(vehicleId: Long) {
        vehicleRepository.deleteVehicleById(vehicleId)
    }
}
