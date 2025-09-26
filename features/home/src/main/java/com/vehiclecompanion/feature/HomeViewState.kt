package com.vehiclecompanion.feature

import com.vehiclecompanion.util.SingleUseValue

data class HomeViewState(
    val selectedTabIndex: Int = 0,
    val navigateToGarage: SingleUseValue<Unit>? = null,
    val navigateToPlaces: SingleUseValue<Unit>? = null,
    val navigateToFavorites: SingleUseValue<Unit>? = null
)
