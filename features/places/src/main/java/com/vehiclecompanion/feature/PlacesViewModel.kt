package com.vehiclecompanion.feature

import com.vehiclecompanion.base.BaseViewModel
import com.vehiclecompanion.events.IEventBus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class PlacesViewModel @Inject constructor(
    override var eventBus: IEventBus
) : BaseViewModel<PlacesAction, PlacesViewState>() {
    override var _viewState = MutableStateFlow(PlacesViewState())

    override fun onActionReceived(viewAction: PlacesAction) {
        super.onActionReceived(viewAction)
    }
}
