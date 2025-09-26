package com.android.vehiclecompanion

import android.Manifest
import android.os.Build
import com.vehiclecompanion.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel<MainAction, MainViewState>() {
    override val _viewState = MutableStateFlow(MainViewState())

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            postAction(MainAction.OnPermissionsListUpdated(Manifest.permission.POST_NOTIFICATIONS))
        }
    }
}
