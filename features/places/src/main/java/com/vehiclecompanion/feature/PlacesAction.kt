package com.vehiclecompanion.feature

import com.vehiclecompanion.base.BaseAction
import com.vehiclecompanion.model.PlaceUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

sealed interface PlacesAction : BaseAction<PlacesViewState> {

    data object ToggleViewMode : PlacesAction {
        override fun updateData(previousData: MutableStateFlow<PlacesViewState>) {
            previousData.update { it.copy(isListView = !it.isListView) }
        }
    }

    data class OnPlacesReceived(val places: List<PlaceUiModel>) : PlacesAction {
        override fun updateData(previousData: MutableStateFlow<PlacesViewState>) {
            previousData.update {
                it.copy(
                    places = places
                )
            }
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

    data class ToggleFavorite(val poi: PlaceUiModel) : PlacesAction {
        override fun updateData(previousData: MutableStateFlow<PlacesViewState>) {
            previousData.update { currentState ->
                val updatedFavorites = if (currentState.favorites.contains(poi.id)) {
                    currentState.favorites - poi.id
                } else {
                    currentState.favorites + poi.id
                }

                currentState.copy(favorites = updatedFavorites)
            }
        }
    }

    data class SearchPlaces(val query: String) : PlacesAction {
        override fun updateData(previousData: MutableStateFlow<PlacesViewState>) {
            previousData.update { currentState ->
                val filteredPlaces = if (query.isBlank()) {
                    emptyList()
                } else {
                    currentState.places.filter { place ->
                        place.name.contains(query, ignoreCase = true) ||
                            place.category.contains(query, ignoreCase = true)
                    }
                }

                currentState.copy(
                    searchQuery = query,
                    filteredPlaces = filteredPlaces
                )
            }
        }
    }
}
