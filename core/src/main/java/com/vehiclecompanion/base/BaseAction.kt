package com.vehiclecompanion.base

import kotlinx.coroutines.flow.MutableStateFlow

interface BaseAction<Data> {
    fun updateData(previousData: MutableStateFlow<Data>) = Unit
}
