package com.vehiclecompanion.feature

import com.vehiclecompanion.base.BaseAction
import com.vehiclecompanion.model.PlaceUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

sealed interface FavoritesAction : BaseAction<FavoritesViewState> {

    data class FavoritesLoaded(val favorites: List<PlaceUiModel>) : FavoritesAction {
        override fun updateData(previousData: MutableStateFlow<FavoritesViewState>) {
            previousData.update {
                it.copy(favorites = favorites)
            }
        }
    }

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

    data class SearchFavorites(val query: String) : FavoritesAction {
        override fun updateData(previousData: MutableStateFlow<FavoritesViewState>) {
            previousData.update { currentState ->
                val filteredFavorites = if (query.isBlank()) {
                    emptyList()
                } else {
                    currentState.favorites.filter { favorite ->
                        favorite.name.contains(query, ignoreCase = true) ||
                            favorite.category.contains(query, ignoreCase = true)
                    }
                }

                currentState.copy(
                    searchQuery = query,
                    filteredFavorites = filteredFavorites
                )
            }
        }
    }
}
