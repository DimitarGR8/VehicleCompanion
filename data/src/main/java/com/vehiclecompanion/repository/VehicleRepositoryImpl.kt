package com.vehiclecompanion.repository

import com.vehiclecompanion.database.dao.VehicleDao
import com.vehiclecompanion.mapper.mapToDomain
import com.vehiclecompanion.mapper.mapToEntity
import com.vehiclecompanion.model.VehicleModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VehicleRepositoryImpl @Inject constructor(
    private val vehicleDao: VehicleDao
) : VehicleRepository {

    override fun getAllVehicles(): Flow<List<VehicleModel>> {
        return vehicleDao.getAllVehicles().map { entities ->
            entities.map { it.mapToDomain() }
        }
    }

    override suspend fun getVehicleById(id: Long): VehicleModel? {
        return vehicleDao.getVehicleById(id)?.mapToDomain()
    }

    override suspend fun insertVehicle(vehicle: VehicleModel): Long {
        return vehicleDao.insertVehicle(vehicle.mapToEntity())
    }

    override suspend fun updateVehicle(vehicle: VehicleModel) {
        vehicleDao.updateVehicle(vehicle.mapToEntity())
    }

    override suspend fun deleteVehicle(vehicle: VehicleModel) {
        vehicleDao.deleteVehicle(vehicle.mapToEntity())
    }

    override suspend fun deleteVehicleById(id: Long) {
        vehicleDao.deleteVehicleById(id)
    }

    override suspend fun getVehicleCount(): Int {
        return vehicleDao.getVehicleCount()
    }
}
