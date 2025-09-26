package com.vehiclecompanion.repository

import com.vehiclecompanion.mapper.mapToDomain
import com.vehiclecompanion.model.PoiModel
import com.vehiclecompanion.remote.api.ApiHelper
import com.vehiclecompanion.remote.api.FeaturesApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PoiRepositoryImpl @Inject constructor(
    private val apiService: FeaturesApi,
    private val apiHelper: ApiHelper
) : PoiRepository {

    override suspend fun discoverPois(
        swCornerLat: Double,
        swCornerLng: Double,
        neCornerLat: Double,
        neCornerLng: Double,
        pageSize: Int
    ): List<PoiModel> {
        return apiHelper.makeApiCall {
            val swCorner = "$swCornerLng,$swCornerLat"
            val neCorner = "$neCornerLng,$neCornerLat"

            apiService.discoverPois(
                swCorner = swCorner,
                neCorner = neCorner,
                pageSize = pageSize
            )
        }.mapToDomain()
    }
}
