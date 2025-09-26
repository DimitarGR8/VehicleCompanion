package com.vehiclecompanion.composables.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vehiclecompanion.presentation.R
import com.vehiclecompanion.theme.Dimens

@Composable
fun RatingRow(rating: Double) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(5) { index ->
            Icon(
                painter = if (index < rating.toInt()) {
                    painterResource(R.drawable.ic_star)
                } else {
                    painterResource(R.drawable.ic_star_outline)
                },
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(16.dp)
            )
        }
        Spacer(modifier = Modifier.width(Dimens.smallPadding))
        Text(
            text = stringResource(R.string.rating_format, rating),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
