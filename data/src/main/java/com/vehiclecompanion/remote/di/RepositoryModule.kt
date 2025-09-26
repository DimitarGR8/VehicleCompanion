package com.vehiclecompanion.remote.di

import com.vehiclecompanion.repository.FavoritePoiRepository
import com.vehiclecompanion.repository.FavoritePoiRepositoryImpl
import com.vehiclecompanion.repository.PoiRepository
import com.vehiclecompanion.repository.PoiRepositoryImpl
import com.vehiclecompanion.repository.VehicleRepository
import com.vehiclecompanion.repository.VehicleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPoiRepository(
        poiRepositoryImpl: PoiRepositoryImpl
    ): PoiRepository

    @Binds
    @Singleton
    abstract fun bindFavoritePoiRepository(
        favoritePoiRepositoryImpl: FavoritePoiRepositoryImpl
    ): FavoritePoiRepository

    @Binds
    @Singleton
    abstract fun bindVehicleRepository(
        vehicleRepositoryImpl: VehicleRepositoryImpl
    ): VehicleRepository
}
