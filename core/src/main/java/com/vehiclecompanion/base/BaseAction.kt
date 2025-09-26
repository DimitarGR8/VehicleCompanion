package com.happywebsocketbirthday.base

import kotlinx.coroutines.flow.MutableStateFlow

interface BaseAction<Data> {
    fun updateData(previousData: MutableStateFlow<Data>) = Unit
}
