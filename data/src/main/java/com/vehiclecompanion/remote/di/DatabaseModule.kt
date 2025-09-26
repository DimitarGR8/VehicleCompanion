package com.vehiclecompanion.remote.di

import android.content.Context
import androidx.room.Room
import com.vehiclecompanion.database.VehicleCompanionDatabase
import com.vehiclecompanion.database.dao.FavoritePoiDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideVehicleCompanionDatabase(
        @ApplicationContext context: Context
    ): VehicleCompanionDatabase {
        return Room.databaseBuilder(
            context,
            VehicleCompanionDatabase::class.java,
            VehicleCompanionDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideFavoritePoiDao(
        database: VehicleCompanionDatabase
    ): FavoritePoiDao {
        return database.favoritePoiDao()
    }
}
