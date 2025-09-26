package com.vehiclecompanion.composables.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.vehiclecompanion.presentation.R
import com.vehiclecompanion.theme.Dimens
import com.vehiclecompanion.theme.Theme

@Composable
fun ImagePickerButton(
    imageUri: String?,
    onImageSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { onImageSelected(it.toString()) }
    }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.vehicle_image),
            style = Theme.typography.regular14,
            color = Theme.colors.textFieldTextColor
        )

        Spacer(modifier = Modifier.height(Dimens.halfDefaultPadding))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clickable { launcher.launch("image/*") },
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            colors = CardDefaults.cardColors(
                containerColor = Theme.colors.backgroundGrey
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .border(
                        width = 1.dp,
                        color = Theme.colors.borderColorLight,
                        shape = RoundedCornerShape(Dimens.halfDefaultPadding)
                    )
                    .clip(RoundedCornerShape(Dimens.halfDefaultPadding)),
                contentAlignment = Alignment.Center
            ) {
                if (imageUri != null && imageUri.isNotEmpty()) {
                    // Show selected image
                    AsyncImage(
                        model = imageUri,
                        contentDescription = stringResource(R.string.selected_vehicle_image),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        contentScale = ContentScale.Crop
                    )

                    // Change image button overlay
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .padding(Dimens.halfDefaultPadding),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = Theme.colors.primary.copy(alpha = 0.9f)
                            ),
                            modifier = Modifier.padding(4.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.change),
                                style = Theme.typography.regular12,
                                color = Theme.colors.primaryTextColor,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                } else {
                    // Show placeholder
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_plus),
                            contentDescription = stringResource(R.string.add_image),
                            tint = Theme.colors.hintColor,
                            modifier = Modifier.size(32.dp)
                        )

                        Spacer(modifier = Modifier.height(Dimens.halfDefaultPadding))

                        Text(
                            text = stringResource(R.string.add_vehicle_photo),
                            style = Theme.typography.regular14,
                            color = Theme.colors.hintColor
                        )
                    }
                }
            }
        }

        if (imageUri != null && imageUri.isNotEmpty()) {
            Spacer(modifier = Modifier.height(Dimens.halfDefaultPadding))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(Dimens.halfDefaultPadding)
            ) {
                TextButton(
                    onClick = { launcher.launch("image/*") },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_edit),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(stringResource(R.string.change_image))
                }

                TextButton(
                    onClick = { onImageSelected("") },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_trash),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Theme.colors.error
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = stringResource(R.string.remove),
                        color = Theme.colors.error
                    )
                }
            }
        }
    }
}
