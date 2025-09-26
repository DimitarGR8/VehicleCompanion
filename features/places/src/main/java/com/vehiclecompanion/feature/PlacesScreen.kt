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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import com.vehiclecompanion.composables.components.EmptyState
import com.vehiclecompanion.composables.components.PlaceDetailsSheet
import com.vehiclecompanion.composables.components.RatingRow
import com.vehiclecompanion.ext.noRippleClickable
import com.vehiclecompanion.model.PlaceUiModel
import com.vehiclecompanion.navigation.AppNavigator
import com.vehiclecompanion.presentation.R
import com.vehiclecompanion.theme.Dimens

@Composable
fun PlacesScreen(
    navigator: AppNavigator,
    viewModel: PlacesViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState.collectAsState()

    with(viewModel) {
        PlacesScreenContent(
            viewState = viewState,
            onToggleViewMode = { postAction(PlacesAction.ToggleViewMode) },
            onSearchPlaces = { postAction(PlacesAction.SearchPlaces(it)) },
            onShowPlaceDetails = { postAction(PlacesAction.ShowPlaceDetails(it)) },
            onHidePlaceDetails = { postAction(PlacesAction.HidePlaceDetails) },
            onToggleFavorite = { postAction(PlacesAction.ToggleFavorite(it)) }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PlacesScreenContent(
    viewState: PlacesViewState,
    onToggleViewMode: () -> Unit,
    onSearchPlaces: (String) -> Unit,
    onShowPlaceDetails: (PlaceUiModel) -> Unit,
    onHidePlaceDetails: () -> Unit,
    onToggleFavorite: (PlaceUiModel) -> Unit,
) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.screenWidthDp > configuration.screenHeightDp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.defaultPadding)
    ) {
        // Header with toggle button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.places_to_visit),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Row {
                IconButton(
                    onClick = onToggleViewMode
                ) {
                    Icon(
                        painter = if (viewState.isListView) {
                            painterResource(R.drawable.ic_grid)
                        } else {
                            painterResource(
                                R.drawable.ic_list
                            )
                        },
                        contentDescription = if (viewState.isListView) {
                            stringResource(
                                R.string.switch_to_grid
                            )
                        } else {
                            stringResource(
                                R.string.switch_to_list
                            )
                        }
                    )
                }
            }
        }

        // Search Bar
        OutlinedTextField(
            value = viewState.searchQuery,
            onValueChange = onSearchPlaces,
            label = { Text(stringResource(R.string.search_places_hint)) },
            leadingIcon = {
                Icon(
                    painterResource(R.drawable.ic_search),
                    contentDescription = stringResource(R.string.search)
                )
            },
            trailingIcon = {
                if (viewState.searchQuery.isNotEmpty()) {
                    IconButton(
                        onClick = { onSearchPlaces("") }
                    ) {
                        Icon(
                            painterResource(R.drawable.ic_clear),
                            contentDescription = stringResource(R.string.clear)
                        )
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Dimens.halfDefaultPadding),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(Dimens.halfDefaultPadding))

        when {
            viewState.displayPlaces.isEmpty() && viewState.searchQuery.isNotEmpty() -> {
                EmptyState(
                    iconRes = R.drawable.ic_search,
                    title = stringResource(
                        R.string.no_items_found,
                        stringResource(R.string.places).lowercase()
                    ),
                    subtitle = stringResource(R.string.try_adjusting_search),
                    noButton = true
                )
            }

            viewState.displayPlaces.isEmpty() && viewState.places.isEmpty() -> {
                EmptyState(
                    iconRes = R.drawable.ic_map_pin,
                    title = stringResource(R.string.no_places_available),
                    subtitle = stringResource(R.string.check_connection_try_again),
                    noButton = true
                )
            }

            else -> {
                PlacesList(
                    places = viewState.displayPlaces,
                    isListView = viewState.isListView,
                    isLandscape = isLandscape,
                    onPlaceClick = onShowPlaceDetails,
                    onFavoriteClick = onToggleFavorite
                )
            }
        }
    }

    // Place Details Bottom Sheet
    if (viewState.showPlaceDetails && viewState.selectedPlace != null) {
        PlaceDetailsSheet(
            place = viewState.selectedPlace,
            isFavorite = viewState.selectedPlace.isFavorite,
            onDismiss = onHidePlaceDetails,
            onFavoriteClick = { onToggleFavorite(viewState.selectedPlace) }
        )
    }
}

@Composable
private fun PlacesList(
    places: List<PlaceUiModel>,
    isListView: Boolean,
    isLandscape: Boolean,
    onPlaceClick: (PlaceUiModel) -> Unit,
    onFavoriteClick: (PlaceUiModel) -> Unit
) {
    if (!isListView || (isLandscape && places.size > 4)) {
        // Grid layout for map view or landscape with many items
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 280.dp),
            horizontalArrangement = Arrangement.spacedBy(Dimens.halfDefaultPadding),
            verticalArrangement = Arrangement.spacedBy(Dimens.halfDefaultPadding),
            contentPadding = PaddingValues(bottom = Dimens.defaultPadding)
        ) {
            items(places) { place ->
                PlaceCard(
                    place = place,
                    isFavorite = place.isFavorite,
                    isGridView = true,
                    onClick = { onPlaceClick(place) },
                    onFavoriteClick = { onFavoriteClick(place) }
                )
            }
        }
    } else {
        // List layout
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(Dimens.halfDefaultPadding),
            contentPadding = PaddingValues(bottom = Dimens.defaultPadding)
        ) {
            items(places) { place ->
                PlaceCard(
                    place = place,
                    isFavorite = place.isFavorite,
                    isGridView = false,
                    onClick = { onPlaceClick(place) },
                    onFavoriteClick = { onFavoriteClick(place) }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PlaceCard(
    place: PlaceUiModel,
    isFavorite: Boolean,
    isGridView: Boolean,
    onClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .then(
                if (isGridView) {
                    Modifier.height(200.dp)
                } else {
                    Modifier.height(120.dp)
                }
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = Dimens.smallPadding)
    ) {
        if (isGridView) {
            GridPlaceCardContent(place, isFavorite, onFavoriteClick)
        } else {
            ListPlaceCardContent(place, isFavorite, onFavoriteClick)
        }
    }
}

@Composable
private fun GridPlaceCardContent(
    place: PlaceUiModel,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        ) {
            AsyncImage(
                model = place.imageUrl,
                contentDescription = place.name,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Icon(
                painter = if (isFavorite) {
                    painterResource(R.drawable.ic_heart)
                } else {
                    painterResource(
                        R.drawable.ic_heart_outline
                    )
                },
                contentDescription = if (isFavorite) {
                    stringResource(
                        R.string.remove_from_favorites
                    )
                } else {
                    stringResource(
                        R.string.add_to_favorites
                    )
                },
                tint = if (isFavorite) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .size(24.dp)
                    .noRippleClickable { onFavoriteClick() }
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimens.halfDefaultPadding)
        ) {
            Text(
                text = place.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = place.category,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.weight(1f))

            RatingRow(rating = place.rating)
        }
    }
}

@Composable
private fun ListPlaceCardContent(
    place: PlaceUiModel,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.halfDefaultPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = place.imageUrl,
            contentDescription = place.name,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(Dimens.halfDefaultPadding)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(Dimens.halfDefaultPadding))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = place.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = place.category,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(Dimens.smallPadding))

            RatingRow(rating = place.rating)
        }

        Icon(
            painter = if (isFavorite) {
                painterResource(R.drawable.ic_heart)
            } else {
                painterResource(
                    R.drawable.ic_heart_outline
                )
            },
            contentDescription = if (isFavorite) "Remove from favorites" else "Add to favorites",
            tint = if (isFavorite) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier
                .size(24.dp)
                .noRippleClickable { onFavoriteClick() }
        )
    }
}
