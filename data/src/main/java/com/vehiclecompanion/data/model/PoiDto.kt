package com.vehiclecompanion.data.model

import com.google.gson.annotations.SerializedName

data class PoiDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("primary_category_display_name")
    val primaryCategoryDisplayName: String,
    @SerializedName("rating")
    val rating: Double?,
    @SerializedName("v_320x320_url")
    val imageUrl: String,
    @SerializedName("loc")
    val location: List<Double>
)
