package com.vehiclecompanion.repository

import com.vehiclecompanion.model.PoiModel

interface PoiRepository {
    suspend fun discoverPois(
        swCornerLat: Double,
        swCornerLng: Double,
        neCornerLat: Double,
        neCornerLng: Double,
        pageSize: Int = 50
    ): List<PoiModel>
}