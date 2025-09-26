package com.android.vehiclecompanion

data class MainViewState(
    val statusLightIcons: Boolean = true,
    val permissionsToRequest: List<String> = listOf(),
    val visiblePermissionsDialogQueue: List<String> = emptyList()
)
