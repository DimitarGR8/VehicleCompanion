package com.vehiclecompanion.model

data class VehicleModel(
    val id: Long = 0,
    val name: String,
    val make: String,
    val model: String,
    val year: Int,
    val vin: String? = null,
    val fuelType: String,
    val imageUri: String? = null
)
