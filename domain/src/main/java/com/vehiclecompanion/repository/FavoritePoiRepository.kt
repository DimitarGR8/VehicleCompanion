package com.vehiclecompanion.repository

import com.vehiclecompanion.model.PoiModel
import kotlinx.coroutines.flow.Flow

interface FavoritePoiRepository {

    fun getAllFavorites(): Flow<List<PoiModel>>

    suspend fun getFavoriteById(poiId: Int): PoiModel?

    suspend fun isFavorite(poiId: Int): Boolean

    suspend fun getFavoriteIds(): List<Int>

    fun getFavoriteIdsFlow(): Flow<List<Int>>

    suspend fun addToFavorites(poi: PoiModel)

    suspend fun removeFromFavorites(poiId: Int)

    suspend fun toggleFavorite(poi: PoiModel): Boolean
}
