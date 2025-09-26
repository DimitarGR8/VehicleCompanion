package com.vehiclecompanion.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vehiclecompanion.database.entities.FavoritePoiEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritePoiDao {

    @Query("SELECT * FROM favorite_pois ORDER BY savedAt DESC")
    fun getAllFavorites(): Flow<List<FavoritePoiEntity>>

    @Query("SELECT * FROM favorite_pois WHERE id = :poiId LIMIT 1")
    suspend fun getFavoriteById(poiId: Int): FavoritePoiEntity?

    @Query("SELECT EXISTS(SELECT 1 FROM favorite_pois WHERE id = :poiId)")
    suspend fun isFavorite(poiId: Int): Boolean

    @Query("SELECT id FROM favorite_pois")
    suspend fun getAllFavoriteIds(): List<Int>

    @Query("SELECT id FROM favorite_pois")
    fun getAllFavoriteIdsFlow(): Flow<List<Int>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: FavoritePoiEntity)

    @Delete
    suspend fun deleteFavorite(favorite: FavoritePoiEntity)

    @Query("DELETE FROM favorite_pois WHERE id = :poiId")
    suspend fun deleteFavoriteById(poiId: Int)

    @Query("DELETE FROM favorite_pois")
    suspend fun deleteAllFavorites()
}
