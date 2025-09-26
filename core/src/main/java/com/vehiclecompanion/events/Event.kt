package com.vehiclecompanion.events

sealed interface Event {
    interface ChangeStatusIconColor : Event {
        val lightIcons: Boolean
    }

    open class ShowLoader(val show: Boolean) : Event
}
