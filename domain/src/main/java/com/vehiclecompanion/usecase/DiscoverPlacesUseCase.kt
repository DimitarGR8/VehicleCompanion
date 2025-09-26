package com.vehiclecompanion.usecase

import com.vehiclecompanion.model.PoiModel
import com.vehiclecompanion.repository.PoiRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiscoverPlacesUseCase @Inject constructor(
    private val poiRepository: PoiRepository
) {
    suspend operator fun invoke(
        swCornerLat: Double,
        swCornerLng: Double,
        neCornerLat: Double,
        neCornerLng: Double,
        pageSize: Int = 50
    ): List<PoiModel> {
        return poiRepository.discoverPois(
            swCornerLat = swCornerLat,
            swCornerLng = swCornerLng,
            neCornerLat = neCornerLat,
            neCornerLng = neCornerLng,
            pageSize = pageSize
        )
    }
}
