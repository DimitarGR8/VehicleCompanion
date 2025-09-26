package com.vehiclecompanion.util

class SingleUseValue<T>(value: T?) {
    private var used = false
    private val _value: T? = value

    fun peekValue(): T? {
        return if (!used && _value != null) {
            used = true
            _value
        } else {
            null
        }
    }
}

fun <T> T.toSingleUseValue(): SingleUseValue<T> = SingleUseValue(this)
