package com.vehiclecompanion.usecase

import com.vehiclecompanion.model.VehicleModel
import com.vehiclecompanion.repository.VehicleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllVehiclesUseCase @Inject constructor(
    private val vehicleRepository: VehicleRepository
) {
    operator fun invoke(): Flow<List<VehicleModel>> {
        return vehicleRepository.getAllVehicles()
    }
}
