package com.vehiclecompanion.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vehiclecompanion.database.dao.FavoritePoiDao
import com.vehiclecompanion.database.entities.FavoritePoiEntity

@Database(
    entities = [FavoritePoiEntity::class],
    version = 1,
    exportSchema = true
)
abstract class VehicleCompanionDatabase : RoomDatabase() {

    abstract fun favoritePoiDao(): FavoritePoiDao

    companion object {
        const val DATABASE_NAME = "vehicle_companion_database"

        fun create(context: Context): VehicleCompanionDatabase {
            return Room.databaseBuilder(
                context,
                VehicleCompanionDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}
