package com.vehiclecompanion.events

import com.vehiclecompanion.enums.DialogTypes

sealed interface Event {
    interface ChangeStatusIconColor : Event {
        val lightIcons: Boolean
    }

    open class ShowCommonDialog(
        val dialogType: DialogTypes,
        val isErrorDialog: Boolean = false,
        val onButtonClick: () -> Unit = {}
    ) : Event

    open class ShowLoader(val show: Boolean) : Event
}
