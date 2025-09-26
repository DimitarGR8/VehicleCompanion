package com.vehiclecompanion.repository

import com.vehiclecompanion.model.VehicleModel
import kotlinx.coroutines.flow.Flow

interface VehicleRepository {

    fun getAllVehicles(): Flow<List<VehicleModel>>

    suspend fun getVehicleById(id: Long): VehicleModel?

    suspend fun insertVehicle(vehicle: VehicleModel): Long

    suspend fun updateVehicle(vehicle: VehicleModel)

    suspend fun deleteVehicle(vehicle: VehicleModel)

    suspend fun deleteVehicleById(id: Long)

    suspend fun getVehicleCount(): Int
}
