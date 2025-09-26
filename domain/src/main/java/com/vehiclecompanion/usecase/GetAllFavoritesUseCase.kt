package com.vehiclecompanion.usecase

import com.vehiclecompanion.model.PoiModel
import com.vehiclecompanion.repository.FavoritePoiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllFavoritesUseCase @Inject constructor(
    private val favoritePoiRepository: FavoritePoiRepository
) {
    operator fun invoke(): Flow<List<PoiModel>> {
        return favoritePoiRepository.getAllFavorites()
    }
}
