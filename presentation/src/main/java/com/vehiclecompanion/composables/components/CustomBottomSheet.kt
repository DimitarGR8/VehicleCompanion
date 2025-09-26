package com.vehiclecompanion.composables.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.vehiclecompanion.theme.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomSheet(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    maxHeightFraction: Float = 0.8f,
    enableScroll: Boolean = true,
    showDragHandle: Boolean = true,
    content: @Composable ColumnScope.() -> Unit
) {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current

    // Create bottom sheet state with partial expand disabled
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    // Calculate maximum height in dp
    val screenHeightDp = configuration.screenHeightDp.dp
    val maxHeight = screenHeightDp * maxHeightFraction

    // Reserve space for system UI and drag handle
    val systemBarsHeight = with(density) {
        WindowInsets.systemBars.getTop(density).toDp() +
            WindowInsets.systemBars.getBottom(density).toDp()
    }
    val dragHandleHeight = if (showDragHandle) 24.dp else 0.dp
    val availableHeight = maxHeight - systemBarsHeight - dragHandleHeight - (Dimens.defaultPadding * 2)

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        modifier = modifier.wrapContentHeight(),
        dragHandle = if (showDragHandle) {
            @Composable { BottomSheetDefaults.DragHandle() }
        } else {
            null
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .heightIn(max = availableHeight)
                .padding(horizontal = Dimens.defaultPadding)
                .let { baseModifier ->
                    if (enableScroll) {
                        baseModifier.verticalScroll(rememberScrollState())
                    } else {
                        baseModifier
                    }
                }
        ) {
            content()
        }
    }
}
