package com.vehiclecompanion.feature

import androidx.lifecycle.viewModelScope
import com.vehiclecompanion.base.BaseViewModel
import com.vehiclecompanion.events.IEventBus
import com.vehiclecompanion.model.VehicleModel
import com.vehiclecompanion.usecase.DeleteVehicleUseCase
import com.vehiclecompanion.usecase.GetAllVehiclesUseCase
import com.vehiclecompanion.usecase.SaveVehicleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GarageViewModel @Inject constructor(
    override var eventBus: IEventBus,
    private val getAllVehiclesUseCase: GetAllVehiclesUseCase,
    private val saveVehicleUseCase: SaveVehicleUseCase,
    private val deleteVehicleUseCase: DeleteVehicleUseCase
) : BaseViewModel<GarageAction, GarageViewState>() {

    override var _viewState = MutableStateFlow(GarageViewState())

    init {
        loadVehicles()
    }

    override fun onActionReceived(viewAction: GarageAction) {
        super.onActionReceived(viewAction)

        when (viewAction) {
            is GarageAction.SaveVehicle -> {
                handleSaveVehicle(viewAction.vehicle)
            }

            is GarageAction.DeleteVehicle -> {
                handleDeleteVehicle(viewAction.vehicleId)
            }

            else -> {}
        }
    }

    private fun loadVehicles() {
        getAllVehiclesUseCase()
            .onEach { vehicles ->
                postAction(GarageAction.VehiclesLoaded(vehicles))
            }
            .launchIn(viewModelScope)
    }

    private fun handleSaveVehicle(vehicle: VehicleModel) {
        execute {
            saveVehicleUseCase(vehicle)
            postAction(GarageAction.HideAddVehicleDialog)
            postAction(GarageAction.HideEditVehicleDialog)
        }
    }

    private fun handleDeleteVehicle(vehicleId: Long) {
        execute {
            deleteVehicleUseCase(vehicleId)
        }
    }
}
