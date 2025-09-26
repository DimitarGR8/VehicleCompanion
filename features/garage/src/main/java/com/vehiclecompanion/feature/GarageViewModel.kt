package com.vehiclecompanion.feature

import com.vehiclecompanion.base.BaseViewModel
import com.vehiclecompanion.events.IEventBus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class GarageViewModel @Inject constructor(
    override var eventBus: IEventBus
) : BaseViewModel<GarageAction, GarageViewState>() {

    override var _viewState = MutableStateFlow(GarageViewState())
}
