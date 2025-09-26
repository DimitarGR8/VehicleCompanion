package com.vehiclecompanion.feature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.vehiclecompanion.composables.components.AddEditVehicleDialog
import com.vehiclecompanion.composables.components.EmptyState
import com.vehiclecompanion.model.VehicleModel
import com.vehiclecompanion.navigation.AppNavigator
import com.vehiclecompanion.presentation.R
import com.vehiclecompanion.theme.Dimens

@Composable
fun GarageScreen(
    navigator: AppNavigator,
    viewModel: GarageViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState.collectAsState()

    with(viewModel) {
        GarageScreenContent(
            viewState = viewState,
            onAddVehicleClick = {
                postAction(GarageAction.ShowAddVehicleDialog)
            },
            onEditVehicleClick = { vehicle ->
                postAction(GarageAction.ShowEditVehicleDialog(vehicle))
            },
            onDeleteVehicleClick = { vehicle ->
                postAction(GarageAction.DeleteVehicle(vehicle.id))
            },
            onHideAddDialog = {
                postAction(GarageAction.HideAddVehicleDialog)
            },
            onHideEditDialog = {
                postAction(GarageAction.HideEditVehicleDialog)
            },
            onSaveVehicle = {
                postAction(
                    GarageAction.SaveVehicle(
                        viewState.vehicleForm.toVehicleModel(
                            viewState.editingVehicle?.id ?: 0
                        )
                    )
                )
            },
            onNameChange = { postAction(GarageAction.UpdateVehicleName(it)) },
            onMakeChange = { postAction(GarageAction.UpdateVehicleMake(it)) },
            onModelChange = { postAction(GarageAction.UpdateVehicleModel(it)) },
            onYearChange = { postAction(GarageAction.UpdateVehicleYear(it)) },
            onVinChange = { postAction(GarageAction.UpdateVehicleVin(it)) },
            onFuelTypeChange = { postAction(GarageAction.UpdateVehicleFuelType(it)) },
            onImageChange = { postAction(GarageAction.UpdateVehicleImage(it)) }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun GarageScreenContent(
    viewState: GarageViewState,
    onAddVehicleClick: () -> Unit,
    onEditVehicleClick: (VehicleModel) -> Unit,
    onDeleteVehicleClick: (VehicleModel) -> Unit,
    onHideAddDialog: () -> Unit,
    onHideEditDialog: () -> Unit,
    onSaveVehicle: () -> Unit,
    onNameChange: (String) -> Unit,
    onMakeChange: (String) -> Unit,
    onModelChange: (String) -> Unit,
    onYearChange: (String) -> Unit,
    onVinChange: (String) -> Unit,
    onFuelTypeChange: (String) -> Unit,
    onImageChange: (String) -> Unit
) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.screenWidthDp > configuration.screenHeightDp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.defaultPadding)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.my_garage),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            FloatingActionButton(
                onClick = onAddVehicleClick,
                modifier = Modifier.size(56.dp)
            ) {
                Icon(painterResource(R.drawable.ic_plus), contentDescription = stringResource(R.string.add_vehicle))
            }
        }

        Spacer(modifier = Modifier.height(Dimens.defaultPadding))

        if (viewState.vehicles.isEmpty()) {
            EmptyState(
                iconRes = R.drawable.ic_car,
                title = stringResource(R.string.garage_empty_title),
                subtitle = stringResource(R.string.garage_empty_subtitle),
                actionText = stringResource(R.string.add_vehicle),
                onActionClick = onAddVehicleClick
            )
        } else {
            VehicleList(
                vehicles = viewState.vehicles,
                isLandscape = isLandscape,
                onEditClick = onEditVehicleClick,
                onDeleteClick = onDeleteVehicleClick
            )
        }
    }

    // Add Vehicle Dialog
    if (viewState.showAddVehicleDialog) {
        AddEditVehicleDialog(
            title = stringResource(R.string.add_vehicle),
            name = viewState.vehicleForm.name,
            make = viewState.vehicleForm.make,
            model = viewState.vehicleForm.model,
            year = viewState.vehicleForm.year,
            vin = viewState.vehicleForm.vin,
            fuelType = viewState.vehicleForm.fuelType,
            imageUri = viewState.vehicleForm.imageUri,
            onDismiss = onHideAddDialog,
            onSave = onSaveVehicle,
            onNameChange = onNameChange,
            onMakeChange = onMakeChange,
            onModelChange = onModelChange,
            onYearChange = onYearChange,
            onVinChange = onVinChange,
            onFuelTypeChange = onFuelTypeChange,
            onImageChange = onImageChange,
            isValid = viewState.vehicleForm.isValid
        )
    }

    // Edit Vehicle Dialog
    if (viewState.showEditVehicleDialog && viewState.editingVehicle != null) {
        AddEditVehicleDialog(
            title = stringResource(R.string.add_vehicle),
            name = viewState.vehicleForm.name,
            make = viewState.vehicleForm.make,
            model = viewState.vehicleForm.model,
            year = viewState.vehicleForm.year,
            vin = viewState.vehicleForm.vin,
            fuelType = viewState.vehicleForm.fuelType,
            imageUri = viewState.vehicleForm.imageUri,
            onDismiss = onHideAddDialog,
            onSave = onSaveVehicle,
            onNameChange = onNameChange,
            onMakeChange = onMakeChange,
            onModelChange = onModelChange,
            onYearChange = onYearChange,
            onVinChange = onVinChange,
            onFuelTypeChange = onFuelTypeChange,
            onImageChange = onImageChange,
            isValid = viewState.vehicleForm.isValid
        )
    }
}

@Composable
private fun VehicleList(
    vehicles: List<VehicleModel>,
    isLandscape: Boolean,
    onEditClick: (VehicleModel) -> Unit,
    onDeleteClick: (VehicleModel) -> Unit
) {
    if (isLandscape) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 300.dp),
            horizontalArrangement = Arrangement.spacedBy(Dimens.defaultPadding),
            verticalArrangement = Arrangement.spacedBy(Dimens.defaultPadding),
            contentPadding = PaddingValues(bottom = Dimens.defaultPadding)
        ) {
            items(vehicles) { vehicle ->
                VehicleCard(
                    vehicle = vehicle,
                    onEditClick = { onEditClick(vehicle) },
                    onDeleteClick = { onDeleteClick(vehicle) }
                )
            }
        }
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(Dimens.defaultPadding),
            contentPadding = PaddingValues(bottom = Dimens.defaultPadding)
        ) {
            items(vehicles) { vehicle ->
                VehicleCard(
                    vehicle = vehicle,
                    onEditClick = { onEditClick(vehicle) },
                    onDeleteClick = { onDeleteClick(vehicle) }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun VehicleCard(
    vehicle: VehicleModel,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimens.defaultPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Vehicle Image
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(Dimens.halfDefaultPadding)),
                contentAlignment = Alignment.Center
            ) {
                if (vehicle.imageUri != null) {
                    AsyncImage(
                        model = vehicle.imageUri,
                        contentDescription = stringResource(R.string.vehicle_image),
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Card(
                        modifier = Modifier.fillMaxSize(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painterResource(R.drawable.ic_car),
                                contentDescription = stringResource(R.string.default_vehicle),
                                modifier = Modifier.size(40.dp),
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.width(Dimens.defaultPadding))

            // Vehicle Info
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = vehicle.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = stringResource(R.string.vehicle_year_make_model, vehicle.year, vehicle.make, vehicle.model),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = vehicle.fuelType,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                vehicle.vin?.let { vin ->
                    Text(
                        text = stringResource(R.string.vin_format, vin),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            // Actions
            Column {
                IconButton(onClick = onEditClick) {
                    Icon(
                        painterResource(R.drawable.ic_edit),
                        contentDescription = stringResource(R.string.edit_vehicle)
                    )
                }
                IconButton(onClick = onDeleteClick) {
                    Icon(
                        painterResource(R.drawable.ic_trash),
                        contentDescription = stringResource(R.string.delete_vehicle),
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }
}
