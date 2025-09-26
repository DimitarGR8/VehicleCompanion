package com.vehiclecompanion.feature

import androidx.lifecycle.viewModelScope
import com.vehiclecompanion.base.BaseViewModel
import com.vehiclecompanion.events.IEventBus
import com.vehiclecompanion.model.LocationUiModel
import com.vehiclecompanion.model.PlaceUiModel
import com.vehiclecompanion.model.PoiModel
import com.vehiclecompanion.usecase.DiscoverPlacesUseCase
import com.vehiclecompanion.usecase.GetFavoritePoiIdsUseCase
import com.vehiclecompanion.usecase.ToggleFavoritePoiUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PlacesViewModel @Inject constructor(
    override var eventBus: IEventBus,
    private val discoverPlacesUseCase: DiscoverPlacesUseCase,
    private val getFavoritePoiIdsUseCase: GetFavoritePoiIdsUseCase,
    private val toggleFavoritePoiUseCase: ToggleFavoritePoiUseCase
) : BaseViewModel<PlacesAction, PlacesViewState>() {
    override var _viewState = MutableStateFlow(PlacesViewState())

    init {
        loadPlaces()
        observeFavoriteChanges()
    }

    override fun onActionReceived(viewAction: PlacesAction) {
        super.onActionReceived(viewAction)

        when (viewAction) {
            is PlacesAction.ToggleFavorite -> {
                handleToggleFavorite(viewAction.poi)
            }

            else -> {}
        }
    }

    private fun loadPlaces() {
        val currentState = _viewState.value

        handleNetworkCall(
            call = {
                discoverPlacesUseCase(
                    swCornerLat = currentState.swCornerLat,
                    swCornerLng = currentState.swCornerLng,
                    neCornerLat = currentState.neCornerLat,
                    neCornerLng = currentState.neCornerLng
                )
            },
            onSuccess = { poiModels ->
                loadFavoriteIds { favoriteIds ->
                    val placeUiModels = poiModels.map { poi ->
                        PlaceUiModel(
                            id = poi.id,
                            name = poi.name,
                            url = poi.url,
                            category = poi.category,
                            rating = poi.rating,
                            imageUrl = poi.imageUrl,
                            location = LocationUiModel(
                                latitude = poi.location.latitude,
                                longitude = poi.location.longitude
                            ),
                            isFavorite = favoriteIds.contains(poi.id)
                        )
                    }

                    postAction(PlacesAction.OnPlacesReceived(placeUiModels))
                }
            }
        )
    }

    private fun loadFavoriteIds(onSuccess: (List<Int>) -> Unit) {
        execute {
            val favoriteIds = getFavoritePoiIdsUseCase()
            onSuccess(favoriteIds)
        }
    }

    private fun handleToggleFavorite(placeUiModel: PlaceUiModel) {
        val poiModel = PoiModel(
            id = placeUiModel.id,
            name = placeUiModel.name,
            url = placeUiModel.url,
            category = placeUiModel.category,
            rating = placeUiModel.rating,
            imageUrl = placeUiModel.imageUrl,
            location = com.vehiclecompanion.model.LocationModel(
                latitude = placeUiModel.location.latitude,
                longitude = placeUiModel.location.longitude
            ),
            isFavorite = placeUiModel.isFavorite
        )

        execute {
            val newFavoriteStatus = toggleFavoritePoiUseCase(poiModel)
            // Update the place in the current list
            val currentState = _viewState.value
            val updatedPlaces = currentState.places.map { place ->
                if (place.id == placeUiModel.id) {
                    place.copy(isFavorite = newFavoriteStatus)
                } else {
                    place
                }
            }
            postAction(PlacesAction.OnPlacesReceived(updatedPlaces))
        }
    }

    private fun observeFavoriteChanges() {
        combine(
            _viewState,
            getFavoritePoiIdsUseCase.asFlow()
        ) { viewState, favoriteIds ->
            if (viewState.places.isNotEmpty()) {
                viewState.places.map { place ->
                    place.copy(isFavorite = favoriteIds.contains(place.id))
                }
            } else {
                emptyList()
            }
        }.onEach { updatedPlaces ->
            if (updatedPlaces.isNotEmpty()) {
                postAction(PlacesAction.OnPlacesReceived(updatedPlaces))
            }
        }.launchIn(viewModelScope)
    }
}
