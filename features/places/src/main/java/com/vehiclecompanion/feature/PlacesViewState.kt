package com.vehiclecompanion.feature

import com.vehiclecompanion.model.PlaceUiModel

data class PlacesViewState(
    val places: List<PlaceUiModel> = emptyList(),
    val filteredPlaces: List<PlaceUiModel> = emptyList(),
    val favorites: Set<Int> = emptySet(),
    val isListView: Boolean = true, // true for List, false for Map
    val selectedPlace: PlaceUiModel? = null,
    val showPlaceDetails: Boolean = false,
    val searchQuery: String = "",
    val error: String? = null,
    val swCornerLat: Double = 39.079888,
    val swCornerLng: Double = -84.540499,
    val neCornerLat: Double = 39.113254,
    val neCornerLng: Double = -84.494260
) {
    val displayPlaces: List<PlaceUiModel>
        get() = if (searchQuery.isBlank()) places else filteredPlaces
}
