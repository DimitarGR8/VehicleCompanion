package com.vehiclecompanion.feature

import com.vehiclecompanion.model.PlaceUiModel

data class FavoritesViewState(
    val favorites: List<PlaceUiModel> = emptyList(),
    val filteredFavorites: List<PlaceUiModel> = emptyList(),
    val selectedPlace: PlaceUiModel? = null,
    val showPlaceDetails: Boolean = false,
    val searchQuery: String = "",
    val error: String? = null
) {
    val displayFavorites: List<PlaceUiModel>
        get() = if (searchQuery.isBlank()) favorites else filteredFavorites
}
