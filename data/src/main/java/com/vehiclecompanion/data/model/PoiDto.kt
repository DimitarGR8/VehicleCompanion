package com.vehiclecompanion.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PoiDto(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String,
    @SerialName("primary_category_display_name")
    val primaryCategoryDisplayName: String,
    @SerialName("rating")
    val rating: Int,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("location")
    val location: List<Double>
)
