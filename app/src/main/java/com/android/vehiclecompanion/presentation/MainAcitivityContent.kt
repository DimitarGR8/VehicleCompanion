package com.android.vehiclecompanion.presentation

import android.annotation.SuppressLint
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.android.vehiclecompanion.MainAction
import com.android.vehiclecompanion.MainViewModel
import com.android.vehiclecompanion.presentation.events.AppEventsHandler
import com.android.vehiclecompanion.presentation.scaffold.CustomPrimarySurface
import com.vehiclecompanion.events.EventBusViewModel

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainActivityContent(
    mainViewModel: MainViewModel,
    eventBusViewModel: EventBusViewModel,
) {
    val navHostController = rememberNavController()
    val viewState by mainViewModel.viewState.collectAsStateWithLifecycle()
    val events by eventBusViewModel.events.collectAsStateWithLifecycle()

    // Status bar color
    StatusBarColor(statusLightIcons = viewState.statusLightIcons)

    PermissionsToRequest(viewState.permissionsToRequest)

    // Events
    AppEventsHandler(
        events = events,
        switchSystemBarColors = {
            mainViewModel.postAction(MainAction.ChangeStatusBarColor(it))
        }
    )

    CustomPrimarySurface(
        navHostGraph = navHostController
    )
}

@Composable
private fun PermissionsToRequest(
    permissionsToRequest: List<String>
) {
    val multiplePermissionResultLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = {}
    )
    LaunchedEffect(Unit) {
        multiplePermissionResultLauncher.launch(permissionsToRequest.toTypedArray())
    }
}
