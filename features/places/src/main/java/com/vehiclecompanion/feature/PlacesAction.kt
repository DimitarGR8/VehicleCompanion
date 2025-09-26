package com.vehiclecompanion.feature

import com.vehiclecompanion.base.BaseAction
import com.vehiclecompanion.model.PlaceUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

sealed interface PlacesAction : BaseAction<PlacesViewState> {
    data object LoadPlaces : PlacesAction

    data object ToggleViewMode : PlacesAction {
        override fun updateData(previousData: MutableStateFlow<PlacesViewState>) {
            previousData.update { it.copy(isListView = !it.isListView) }
        }
    }

    data class ShowPlaceDetails(val poi: PlaceUiModel) : PlacesAction {
        override fun updateData(previousData: MutableStateFlow<PlacesViewState>) {
            previousData.update {
                it.copy(
                    selectedPlace = poi,
                    showPlaceDetails = true
                )
            }
        }
    }

    data object HidePlaceDetails : PlacesAction {
        override fun updateData(previousData: MutableStateFlow<PlacesViewState>) {
            previousData.update {
                it.copy(
                    selectedPlace = null,
                    showPlaceDetails = false
                )
            }
        }
    }

    data class ToggleFavorite(val poi: PlaceUiModel) : PlacesAction

    data class SearchPlaces(val query: String) : PlacesAction
}
