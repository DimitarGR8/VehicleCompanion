package com.happywebsocketbirthday.events

import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow

interface IEventBus {
    val events: Flow<Event>
    fun produceEvent(event: Event): Job
}
