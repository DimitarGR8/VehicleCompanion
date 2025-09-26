package com.vehiclecompanion.feature

import com.vehiclecompanion.base.BaseAction
import com.vehiclecompanion.model.PlaceUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

sealed interface FavoritesAction : BaseAction<FavoritesViewState> {
    data object LoadFavorites : FavoritesAction

    data class RemoveFromFavorites(val poi: PlaceUiModel) : FavoritesAction

    data class ShowPlaceDetails(val poi: PlaceUiModel) : FavoritesAction {
        override fun updateData(previousData: MutableStateFlow<FavoritesViewState>) {
            previousData.update {
                it.copy(
                    selectedPlace = poi,
                    showPlaceDetails = true
                )
            }
        }
    }

    data object HidePlaceDetails : FavoritesAction {
        override fun updateData(previousData: MutableStateFlow<FavoritesViewState>) {
            previousData.update {
                it.copy(
                    selectedPlace = null,
                    showPlaceDetails = false
                )
            }
        }
    }

    data class SearchFavorites(val query: String) : FavoritesAction
}
