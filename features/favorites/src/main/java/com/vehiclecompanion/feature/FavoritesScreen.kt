package com.vehiclecompanion.feature

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.vehiclecompanion.theme.Theme

@Composable
fun FavoritesScreen(
    navigator: AppNavigator,
    viewModel: FavoritesViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState.collectAsState()

    with(viewModel) {
        FavoritesScreenContent(
            viewState = viewState,
            onSearchFavorites = { postAction(FavoritesAction.SearchFavorites(it)) },
            onShowPlaceDetails = { postAction(FavoritesAction.ShowPlaceDetails(it)) },
            onHidePlaceDetails = { postAction(FavoritesAction.HidePlaceDetails) },
            onRemoveFromFavorites = { postAction(FavoritesAction.RemoveFromFavorites(it)) }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FavoritesScreenContent(
    viewState: FavoritesViewState,
    onSearchFavorites: (String) -> Unit,
    onShowPlaceDetails: (PlaceUiModel) -> Unit,
    onHidePlaceDetails: () -> Unit,
    onRemoveFromFavorites: (PlaceUiModel) -> Unit
) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.screenWidthDp > configuration.screenHeightDp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.defaultPadding)
    ) {
        // Header
        Text(
            text = stringResource(R.string.my_favorites),
            style = Theme.typography.bold24,
            fontWeight = FontWeight.Bold
        )

        // Search Bar
        if (viewState.favorites.isNotEmpty()) {
            OutlinedTextField(
                value = viewState.searchQuery,
                onValueChange = onSearchFavorites,
                label = { Text(stringResource(R.string.search_favorites_hint)) },
                leadingIcon = {
                    Icon(
                        painterResource(R.drawable.ic_search),
                        contentDescription = stringResource(R.string.search)
                    )
                },
                trailingIcon = {
                    if (viewState.searchQuery.isNotEmpty()) {
                        IconButton(
                            onClick = { onSearchFavorites("") }
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
        }

        Spacer(modifier = Modifier.height(Dimens.halfDefaultPadding))

        when {
            viewState.displayFavorites.isEmpty() -> {
                EmptyState(
                    iconRes = R.drawable.ic_heart_outline,
                    title = if (viewState.searchQuery.isNotEmpty()) {
                        stringResource(
                            R.string.no_items_found,
                            stringResource(R.string.favorites).lowercase()
                        )
                    } else {
                        stringResource(R.string.no_favorites_yet)
                    },
                    subtitle = if (viewState.searchQuery.isNotEmpty()) {
                        stringResource(R.string.try_adjusting_search)
                    } else {
                        stringResource(R.string.add_places_from_places_tab)
                    },
                    actionText = stringResource(R.string.browse_places),
                    noButton = true
                )
            }
            else -> {
                FavoritesList(
                    favorites = viewState.displayFavorites,
                    isLandscape = isLandscape,
                    onPlaceClick = onShowPlaceDetails,
                    onRemoveFavoriteClick = onRemoveFromFavorites
                )
            }
        }
    }

    // Place Details Bottom Sheet
    if (viewState.showPlaceDetails && viewState.selectedPlace != null) {
        PlaceDetailsSheet(
            name = viewState.selectedPlace.name,
            category = viewState.selectedPlace.category,
            rating = viewState.selectedPlace.rating,
            imageUrl = viewState.selectedPlace.imageUrl,
            latitude = viewState.selectedPlace.location.latitude,
            longitude = viewState.selectedPlace.location.longitude,
            url = viewState.selectedPlace.url,
            isFavorite = viewState.selectedPlace.isFavorite,
            onDismiss = onHidePlaceDetails,
            onFavoriteClick = { onRemoveFromFavorites(viewState.selectedPlace) }
        )
    }
}

@Composable
private fun FavoritesList(
    favorites: List<PlaceUiModel>,
    isLandscape: Boolean,
    onPlaceClick: (PlaceUiModel) -> Unit,
    onRemoveFavoriteClick: (PlaceUiModel) -> Unit
) {
    if (isLandscape && favorites.size > 4) {
        // Grid layout for landscape with many items
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 280.dp),
            horizontalArrangement = Arrangement.spacedBy(Dimens.defaultPadding),
            verticalArrangement = Arrangement.spacedBy(Dimens.defaultPadding),
            contentPadding = PaddingValues(bottom = Dimens.defaultPadding)
        ) {
            items(favorites) { favorite ->
                FavoriteCard(
                    place = favorite,
                    isGridView = true,
                    onClick = { onPlaceClick(favorite) },
                    onRemoveFavoriteClick = { onRemoveFavoriteClick(favorite) }
                )
            }
        }
    } else {
        // List layout
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(Dimens.defaultPadding),
            contentPadding = PaddingValues(bottom = Dimens.defaultPadding)
        ) {
            items(favorites) { favorite ->
                FavoriteCard(
                    place = favorite,
                    isGridView = false,
                    onClick = { onPlaceClick(favorite) },
                    onRemoveFavoriteClick = { onRemoveFavoriteClick(favorite) }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun FavoriteCard(
    place: PlaceUiModel,
    isGridView: Boolean,
    onClick: () -> Unit,
    onRemoveFavoriteClick: () -> Unit
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
            GridFavoriteCardContent(place, onRemoveFavoriteClick)
        } else {
            ListFavoriteCardContent(place, onRemoveFavoriteClick)
        }
    }
}

@Composable
private fun GridFavoriteCardContent(
    place: PlaceUiModel,
    onRemoveFavoriteClick: () -> Unit
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
                painter = painterResource(R.drawable.ic_heart),
                contentDescription = stringResource(R.string.remove_from_favorites),
                tint = Theme.colors.error,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(Dimens.halfDefaultPadding)
                    .size(24.dp)
                    .noRippleClickable { onRemoveFavoriteClick() }
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimens.defaultPadding)
        ) {
            Text(
                text = place.name,
                style = Theme.typography.bold16,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = place.category,
                style = Theme.typography.regular12,
                color = Theme.colors.hintColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.weight(1f))

            RatingRow(rating = place.rating)
        }
    }
}

@Composable
private fun ListFavoriteCardContent(
    place: PlaceUiModel,
    onRemoveFavoriteClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.defaultPadding),
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

        Spacer(modifier = Modifier.width(Dimens.defaultPadding))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = place.name,
                style = Theme.typography.bold16,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = place.category,
                style = Theme.typography.regular14,
                color = Theme.colors.hintColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(Dimens.halfDefaultPadding))

            RatingRow(rating = place.rating)
        }

        Icon(
            painter = painterResource(R.drawable.ic_heart),
            contentDescription = "Remove from favorites",
            tint = Theme.colors.error,
            modifier = Modifier
                .size(24.dp)
                .noRippleClickable { onRemoveFavoriteClick() }
        )
    }
}
