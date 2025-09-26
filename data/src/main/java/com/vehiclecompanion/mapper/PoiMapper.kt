package com.vehiclecompanion.mapper

import com.vehiclecompanion.data.model.PoiDto
import com.vehiclecompanion.database.entities.FavoritePoiEntity
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
        rating = rating ?: 0.0,
        imageUrl = imageUrl,
        location = LocationModel(
            longitude = location.getOrElse(0) { 0.0 },
            latitude = location.getOrElse(1) { 0.0 }
        ),
        isFavorite = false
    )
}

fun FavoritePoiEntity.mapToDomain(): PoiModel {
    return PoiModel(
        id = id,
        name = name,
        url = url,
        category = category,
        rating = rating,
        imageUrl = imageUrl,
        location = LocationModel(
            longitude = longitude,
            latitude = latitude
        ),
        isFavorite = true
    )
}

fun PoiModel.mapToEntity(): FavoritePoiEntity {
    return FavoritePoiEntity(
        id = id,
        name = name,
        url = url,
        category = category,
        rating = rating,
        imageUrl = imageUrl,
        longitude = location.longitude,
        latitude = location.latitude
    )
}
