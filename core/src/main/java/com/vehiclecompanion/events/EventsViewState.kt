package com.vehiclecompanion.events

import com.vehiclecompanion.util.SingleUseValue

data class EventsViewState(
    val switchStatusIconColor: SingleUseValue<Event.ChangeStatusIconColor?> = SingleUseValue(null),
    val showCommonDialog: SingleUseValue<Event.ShowCommonDialog?> = SingleUseValue(null),
    val showLoader: SingleUseValue<Boolean> = SingleUseValue(null)
)
