package com.vehiclecompanion.composables.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.vehiclecompanion.composables.buttons.PrimaryButton
import com.vehiclecompanion.composables.buttons.SecondaryButton
import com.vehiclecompanion.presentation.R
import com.vehiclecompanion.theme.Dimens
import com.vehiclecompanion.theme.Theme

@Composable
fun PlaceDetailsSheet(
    name: String,
    category: String,
    rating: Double,
    imageUrl: String,
    latitude: Double,
    longitude: Double,
    url: String,
    isFavorite: Boolean,
    onDismiss: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    val uriHandler = LocalUriHandler.current

    CustomBottomSheet(
        onDismiss = onDismiss,
        maxHeightFraction = 0.75f,
        enableScroll = true
    ) {
        // Header with favorite button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = name,
                style = Theme.typography.bold20,
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
                    tint = if (isFavorite) Theme.colors.error else Theme.colors.hintColor
                )
            }
        }

        Spacer(modifier = Modifier.height(Dimens.halfDefaultPadding))

        // Place Image
        AsyncImage(
            model = imageUrl,
            contentDescription = name,
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
                tint = Theme.colors.primary,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(Dimens.halfDefaultPadding))
            Text(
                text = category,
                style = Theme.typography.regular16,
                color = Theme.colors.hintColor
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
                tint = Theme.colors.primary,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(Dimens.halfDefaultPadding))
            RatingDisplay(rating = rating)
        }

        Spacer(modifier = Modifier.height(Dimens.halfDefaultPadding))

        // Location
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painterResource(R.drawable.ic_map_pin),
                contentDescription = stringResource(R.string.location),
                tint = Theme.colors.primary,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(Dimens.halfDefaultPadding))
            Text(
                text = stringResource(
                    R.string.location_coordinates,
                    latitude,
                    longitude
                ),
                style = Theme.typography.regular14,
                color = Theme.colors.hintColor
            )
        }

        Spacer(modifier = Modifier.height(Dimens.doubleDefaultPadding))

        // Action Buttons
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(Dimens.halfDefaultPadding)
        ) {
            PrimaryButton(
                text = stringResource(R.string.open_in_browser),
                icon = R.drawable.ic_star,
                onClick = { uriHandler.openUri(url) },
                modifier = Modifier.fillMaxWidth()
            )

            SecondaryButton(
                text = stringResource(R.string.directions),
                startIcon = R.drawable.ic_map_pin,
                onClick = { /* TODO: Open in maps */ },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(Dimens.doubleDefaultPadding))
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
                tint = Theme.colors.primary,
                modifier = Modifier.size(16.dp)
            )
        }
        Spacer(modifier = Modifier.width(Dimens.halfDefaultPadding))
        Text(
            text = stringResource(R.string.rating_out_of_five, rating),
            style = Theme.typography.regular14,
            color = Theme.colors.hintColor
        )
    }
}
