package com.vehiclecompanion.mapper

import com.vehiclecompanion.data.model.PoiDto
import com.vehiclecompanion.model.LocationModel
import com.vehiclecompanion.model.PoiModel
import com.vehiclecompanion.model.PoiResponse

fun PoiResponse.mapToDomain(): List<PoiModel> {
    return pois.map { it.mapToDomain() }
}

fun PoiDto.mapToDomain(): PoiModel {
    return PoiModel(
        id = id,
        name = name,
        url = url,
        category = primaryCategoryDisplayName,
        rating = rating,
        imageUrl = imageUrl,
        location = LocationModel(
            longitude = location.getOrElse(0) { 0.0 },
            latitude = location.getOrElse(1) { 0.0 }
        )
    )
}