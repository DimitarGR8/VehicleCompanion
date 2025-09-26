package com.vehiclecompanion.model

data class PlaceUiModel(
    val id: Int,
    val name: String,
    val url: String,
    val category: String,
    val rating: Double,
    val imageUrl: String,
    val location: LocationUiModel,
    val isFavorite: Boolean = false
)

data class LocationUiModel(
    val latitude: Double,
    val longitude: Double
)
