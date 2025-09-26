package com.vehiclecompanion.remote.api

import com.vehiclecompanion.model.PoiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FeaturesApi {

    companion object {
        const val DISCOVER_POIS = "api/v2/pois/discover"
    }

    @GET(DISCOVER_POIS)
    suspend fun discoverPois(
        @Query("sw_corner") swCorner: String,
        @Query("ne_corner") neCorner: String,
        @Query("page_size") pageSize: Int = 50
    ): Response<PoiResponse>
}
