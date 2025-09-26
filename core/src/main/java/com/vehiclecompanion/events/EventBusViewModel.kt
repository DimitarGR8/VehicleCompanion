package com.vehiclecompanion.events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vehiclecompanion.util.SingleUseValue
import com.vehiclecompanion.util.toSingleUseValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class EventBusViewModel @Inject constructor(
    val eventBus: IEventBus
) : ViewModel() {
    private val _events = MutableStateFlow(EventsViewState())
    val events = _events.asStateFlow()

    init {
        eventBus.events.onEach { event ->
            when (event) {
                is Event.ChangeStatusIconColor -> {
                    _events.update {
                        it.copy(switchStatusIconColor = SingleUseValue(event))
                    }
                }

                is Event.ShowLoader -> {
                    _events.update {
                        it.copy(showLoader = event.show.toSingleUseValue())
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}
