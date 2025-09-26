package com.vehiclecompanion.model

import com.google.gson.annotations.SerializedName
import com.vehiclecompanion.data.model.PoiDto

data class PoiResponse(
    @SerializedName("pois")
    val pois: List<PoiDto>,
    @SerializedName("total")
    val total: TotalInfo?
)

data class TotalInfo(
    @SerializedName("value")
    val value: Int,
    @SerializedName("relation")
    val relation: String
)
