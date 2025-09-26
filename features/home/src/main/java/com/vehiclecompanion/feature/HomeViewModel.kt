package com.vehiclecompanion.feature

import com.vehiclecompanion.base.BaseViewModel
import com.vehiclecompanion.events.IEventBus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    override var eventBus: IEventBus,
) : BaseViewModel<HomeAction, HomeViewState>() {
    override var _viewState = MutableStateFlow(HomeViewState())

    init {
        postAction(HomeAction.LightIconsStatusBar)
    }

    override fun onActionReceived(viewAction: HomeAction) {
        super.onActionReceived(viewAction)
    }
}
