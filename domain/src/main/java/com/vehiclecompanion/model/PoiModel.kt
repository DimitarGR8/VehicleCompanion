package com.vehiclecompanion.model

data class PoiModel(
    val id: Int,
    val name: String,
    val url: String,
    val category: String,
    val rating: Double,
    val imageUrl: String,
    val location: LocationModel,
    val isFavorite: Boolean = false
)
