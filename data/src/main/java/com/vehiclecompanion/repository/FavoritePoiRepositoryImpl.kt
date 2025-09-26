package com.vehiclecompanion.repository

import com.vehiclecompanion.database.dao.FavoritePoiDao
import com.vehiclecompanion.mapper.mapToDomain
import com.vehiclecompanion.mapper.mapToEntity
import com.vehiclecompanion.model.PoiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoritePoiRepositoryImpl @Inject constructor(
    private val favoritePoiDao: FavoritePoiDao
) : FavoritePoiRepository {

    override fun getAllFavorites(): Flow<List<PoiModel>> {
        return favoritePoiDao.getAllFavorites().map { entities ->
            entities.map { it.mapToDomain() }
        }
    }

    override suspend fun getFavoriteById(poiId: Int): PoiModel? {
        return favoritePoiDao.getFavoriteById(poiId)?.mapToDomain()
    }

    override suspend fun isFavorite(poiId: Int): Boolean {
        return favoritePoiDao.isFavorite(poiId)
    }

    override suspend fun getFavoriteIds(): List<Int> {
        return favoritePoiDao.getAllFavoriteIds()
    }

    override fun getFavoriteIdsFlow(): Flow<List<Int>> {
        return favoritePoiDao.getAllFavoriteIdsFlow()
    }

    override suspend fun addToFavorites(poi: PoiModel) {
        favoritePoiDao.insertFavorite(poi.mapToEntity())
    }

    override suspend fun removeFromFavorites(poiId: Int) {
        favoritePoiDao.deleteFavoriteById(poiId)
    }

    override suspend fun toggleFavorite(poi: PoiModel): Boolean {
        val isFavorite = isFavorite(poi.id)
        if (isFavorite) {
            removeFromFavorites(poi.id)
        } else {
            addToFavorites(poi)
        }
        return !isFavorite
    }
}
