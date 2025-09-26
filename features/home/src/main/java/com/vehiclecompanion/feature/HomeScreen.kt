package com.vehiclecompanion.feature

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.vehiclecompanion.navigation.AppNavigator
import com.vehiclecompanion.presentation.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigator: AppNavigator,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState.collectAsState()

    with(viewModel) {
        HomeScreenContent(
            navigator = navigator,
            viewState = viewState,
            onTabSelected = { index ->
                postAction(HomeAction.SelectTab(index))
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreenContent(
    navigator: AppNavigator,
    viewState: HomeViewState,
    onTabSelected: (Int) -> Unit
) {
    val tabs = listOf(
        HomeTab(stringResource(R.string.garage), R.drawable.ic_garage),
        HomeTab(stringResource(R.string.places), R.drawable.ic_map_pin),
        HomeTab(stringResource(R.string.favorites), R.drawable.ic_heart_outline)
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                tabs.forEachIndexed { index, tab ->
                    NavigationBarItem(
                        icon = { Icon(painterResource(tab.iconRes), contentDescription = tab.title) },
                        label = { Text(tab.title) },
                        selected = viewState.selectedTabIndex == index,
                        onClick = { onTabSelected(index) }
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (viewState.selectedTabIndex) {
                0 -> GarageScreen(navigator = navigator)
                1 -> PlacesScreen(navigator = navigator)
                2 -> FavoritesScreen(navigator = navigator)
            }
        }
    }
}

data class HomeTab(
    val title: String,
    val iconRes: Int
)
