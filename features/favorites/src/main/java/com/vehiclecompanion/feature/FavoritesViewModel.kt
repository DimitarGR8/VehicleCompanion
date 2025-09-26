package com.vehiclecompanion.feature

import com.vehiclecompanion.base.BaseViewModel
import com.vehiclecompanion.events.IEventBus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    override var eventBus: IEventBus
) : BaseViewModel<FavoritesAction, FavoritesViewState>() {
    override var _viewState = MutableStateFlow(FavoritesViewState())

    override fun onActionReceived(viewAction: FavoritesAction) {
        super.onActionReceived(viewAction)
    }
}
