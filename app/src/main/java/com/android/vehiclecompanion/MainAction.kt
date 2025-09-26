package com.android.vehiclecompanion

import com.vehiclecompanion.base.BaseAction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

sealed interface MainAction : BaseAction<MainViewState> {

    data class OnPermissionsListUpdated(val permissionToAdd: String) : MainAction {
        override fun updateData(previousData: MutableStateFlow<MainViewState>) {
            previousData.update {
                it.copy(
                    permissionsToRequest = previousData.value.permissionsToRequest.plus(
                        permissionToAdd
                    )
                )
            }
        }
    }

    data class ChangeStatusBarColor(
        val statusLightIcons: Boolean
    ) : MainAction {
        override fun updateData(previousData: MutableStateFlow<MainViewState>) {
            previousData.update {
                it.copy(
                    statusLightIcons = statusLightIcons
                )
            }
        }
    }
}
