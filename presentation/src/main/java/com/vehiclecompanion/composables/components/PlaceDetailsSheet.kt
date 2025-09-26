package com.vehiclecompanion.composables.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.vehiclecompanion.model.PlaceUiModel
import com.vehiclecompanion.presentation.R
import com.vehiclecompanion.theme.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceDetailsSheet(
    place: PlaceUiModel,
    isFavorite: Boolean,
    onDismiss: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.screenWidthDp > configuration.screenHeightDp
    val uriHandler = LocalUriHandler.current

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        modifier = Modifier.fillMaxHeight(if (isLandscape) 0.9f else 0.7f),
        dragHandle = { BottomSheetDefaults.DragHandle() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Dimens.defaultPadding)
                .verticalScroll(rememberScrollState())
        ) {
            // Header with favorite button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = place.name,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )

                IconButton(onClick = onFavoriteClick) {
                    Icon(
                        painter = if (isFavorite) {
                            painterResource(
                                R.drawable.ic_heart
                            )
                        } else {
                            painterResource(R.drawable.ic_heart_outline)
                        },
                        contentDescription = if (isFavorite) {
                            stringResource(
                                R.string.remove_from_favorites
                            )
                        } else {
                            stringResource(R.string.add_to_favorites)
                        },
                        tint = if (isFavorite) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(Dimens.halfDefaultPadding))

            // Place Image
            AsyncImage(
                model = place.imageUrl,
                contentDescription = place.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(Dimens.halfDefaultPadding)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(Dimens.defaultPadding))

            // Category
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.ic_menu),
                    contentDescription = stringResource(R.string.category),
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(Dimens.halfDefaultPadding))
                Text(
                    text = place.category,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(Dimens.halfDefaultPadding))

            // Rating
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.ic_star),
                    contentDescription = stringResource(R.string.rating),
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(Dimens.halfDefaultPadding))
                RatingDisplay(rating = place.rating)
            }

            Spacer(modifier = Modifier.height(Dimens.halfDefaultPadding))

            // Location
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.ic_map_pin),
                    contentDescription = stringResource(R.string.location),
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(Dimens.halfDefaultPadding))
                Text(
                    text = stringResource(
                        R.string.location_coordinates,
                        place.location.latitude,
                        place.location.longitude
                    ),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(Dimens.doubleDefaultPadding))

            // Action Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(Dimens.halfDefaultPadding)
            ) {
                Button(
                    onClick = { uriHandler.openUri(place.url) },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(painterResource(R.drawable.ic_star), contentDescription = null)
                    Spacer(modifier = Modifier.width(Dimens.halfDefaultPadding))
                    Text(stringResource(R.string.open_in_browser))
                }

                OutlinedButton(
                    onClick = { /* TODO: Open in maps */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(painterResource(R.drawable.ic_map_pin), contentDescription = null)
                    Spacer(modifier = Modifier.width(Dimens.halfDefaultPadding))
                    Text(stringResource(R.string.directions))
                }
            }

            Spacer(modifier = Modifier.height(Dimens.doubleDefaultPadding))
        }
    }
}

@Composable
private fun RatingDisplay(rating: Double) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(5) { index ->
            Icon(
                painter = if (index < rating) {
                    painterResource(
                        R.drawable.ic_star
                    )
                } else {
                    painterResource(R.drawable.ic_star_outline)
                },
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(16.dp)
            )
        }
        Spacer(modifier = Modifier.width(Dimens.halfDefaultPadding))
        Text(
            text = stringResource(R.string.rating_out_of_five, rating),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
