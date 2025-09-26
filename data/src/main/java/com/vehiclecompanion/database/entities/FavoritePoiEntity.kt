package com.vehiclecompanion.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_pois")
data class FavoritePoiEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val url: String,
    val category: String,
    val rating: Double,
    val imageUrl: String,
    val longitude: Double,
    val latitude: Double,
    val savedAt: Long = System.currentTimeMillis()
)
