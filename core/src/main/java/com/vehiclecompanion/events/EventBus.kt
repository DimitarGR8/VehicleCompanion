package com.vehiclecompanion.events

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

class EventBus @Inject constructor(
    val coroutineScope: CoroutineScope,
    @Named("immediate") val dispatcher: CoroutineDispatcher
) : IEventBus {

    private val _events = MutableSharedFlow<Event>()

    override val events: Flow<Event> = _events

    override fun produceEvent(event: Event) =
        coroutineScope.launch(dispatcher) {
            _events.emit(event)
        }
}
