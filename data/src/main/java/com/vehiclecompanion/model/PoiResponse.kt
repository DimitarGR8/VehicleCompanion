package com.vehiclecompanion.model

import com.vehiclecompanion.data.model.PoiDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PoiResponse(
    @SerialName("pois")
    val pois: List<PoiDto>
)