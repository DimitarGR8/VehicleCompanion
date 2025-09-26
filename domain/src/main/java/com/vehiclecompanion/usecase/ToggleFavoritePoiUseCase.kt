package com.vehiclecompanion.usecase

import com.vehiclecompanion.model.PoiModel
import com.vehiclecompanion.repository.FavoritePoiRepository
import javax.inject.Inject

class ToggleFavoritePoiUseCase @Inject constructor(
    private val favoritePoiRepository: FavoritePoiRepository
) {
    suspend operator fun invoke(poi: PoiModel): Boolean {
        return favoritePoiRepository.toggleFavorite(poi)
    }
}
