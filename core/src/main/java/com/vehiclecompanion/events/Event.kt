package com.happywebsocketbirthday.events

import com.happywebsocketbirthday.enums.DialogTypes
import kotlinx.coroutines.CompletableDeferred

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
