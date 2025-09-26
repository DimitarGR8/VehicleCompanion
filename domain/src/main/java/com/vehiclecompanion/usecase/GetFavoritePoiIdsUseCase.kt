package com.vehiclecompanion.usecase

import com.vehiclecompanion.repository.FavoritePoiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoritePoiIdsUseCase @Inject constructor(
    private val favoritePoiRepository: FavoritePoiRepository
) {
    suspend operator fun invoke(): List<Int> {
        return favoritePoiRepository.getFavoriteIds()
    }

    fun asFlow(): Flow<List<Int>> {
        return favoritePoiRepository.getFavoriteIdsFlow()
    }
}
