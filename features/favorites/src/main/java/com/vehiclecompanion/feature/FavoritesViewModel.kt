package com.vehiclecompanion.feature

import androidx.lifecycle.viewModelScope
import com.vehiclecompanion.base.BaseViewModel
import com.vehiclecompanion.events.IEventBus
import com.vehiclecompanion.model.LocationUiModel
import com.vehiclecompanion.model.PlaceUiModel
import com.vehiclecompanion.model.PoiModel
import com.vehiclecompanion.usecase.GetAllFavoritesUseCase
import com.vehiclecompanion.usecase.ToggleFavoritePoiUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    override var eventBus: IEventBus,
    private val getAllFavoritesUseCase: GetAllFavoritesUseCase,
    private val toggleFavoritePoiUseCase: ToggleFavoritePoiUseCase
) : BaseViewModel<FavoritesAction, FavoritesViewState>() {
    override var _viewState = MutableStateFlow(FavoritesViewState())

    init {
        observeFavorites()
    }

    override fun onActionReceived(viewAction: FavoritesAction) {
        super.onActionReceived(viewAction)

        when (viewAction) {
            is FavoritesAction.RemoveFromFavorites -> {
                handleRemoveFromFavorites(viewAction.poi)
            }
            else -> {}
        }
    }

    private fun observeFavorites() {
        getAllFavoritesUseCase()
            .onEach { favorites ->
                val favoritePlaces = favorites.map { poi ->
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
                        isFavorite = true
                    )
                }
                postAction(FavoritesAction.FavoritesLoaded(favoritePlaces))
            }
            .launchIn(viewModelScope)
    }

    private fun handleRemoveFromFavorites(placeUiModel: PlaceUiModel) {
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
            isFavorite = true
        )

        execute {
            toggleFavoritePoiUseCase(poiModel)
        }
    }
}
