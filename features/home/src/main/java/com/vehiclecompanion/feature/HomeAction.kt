package com.vehiclecompanion.feature

import com.vehiclecompanion.base.BaseAction
import com.vehiclecompanion.events.Event
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

sealed interface HomeAction : BaseAction<HomeViewState> {

    object LightIconsStatusBar : HomeAction, Event.ChangeStatusIconColor {
        override val lightIcons: Boolean = false
    }

    data class SelectTab(val tabIndex: Int) : HomeAction {
        override fun updateData(previousData: MutableStateFlow<HomeViewState>) {
            previousData.update { it.copy(selectedTabIndex = tabIndex) }
        }
    }
}
