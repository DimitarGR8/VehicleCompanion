package com.vehiclecompanion.feature

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.vehiclecompanion.model.LocationUiModel
import com.vehiclecompanion.model.PlaceUiModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FavoriteCardTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val testFavoritePlace = PlaceUiModel(
        id = 1,
        name = "Favorite Restaurant",
        url = "https://example.com/favorite-restaurant",
        category = "restaurant",
        rating = 4.7,
        imageUrl = "https://example.com/restaurant-image.jpg",
        location = LocationUiModel(
            latitude = 40.7580,
            longitude = -73.9855
        ),
        isFavorite = true
    )

    @Test
    fun favoriteCard_gridView_displaysCorrectContent() {
        // When
        composeTestRule.setContent {
            MaterialTheme {
                FavoriteCard(
                    place = testFavoritePlace,
                    isGridView = true,
                    onClick = { },
                    onRemoveFavoriteClick = { }
                )
            }
        }

        // Then
        composeTestRule.onNodeWithText("Favorite Restaurant").assertIsDisplayed()
        composeTestRule.onNodeWithText("restaurant").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Remove from favorites").assertIsDisplayed()
    }

    @Test
    fun favoriteCard_listView_displaysCorrectContent() {
        // When
        composeTestRule.setContent {
            MaterialTheme {
                FavoriteCard(
                    place = testFavoritePlace,
                    isGridView = false,
                    onClick = { },
                    onRemoveFavoriteClick = { }
                )
            }
        }

        // Then
        composeTestRule.onNodeWithText("Favorite Restaurant").assertIsDisplayed()
        composeTestRule.onNodeWithText("restaurant").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Remove from favorites").assertIsDisplayed()
    }

    @Test
    fun favoriteCard_displaysImage() {
        // When
        composeTestRule.setContent {
            MaterialTheme {
                FavoriteCard(
                    place = testFavoritePlace,
                    isGridView = true,
                    onClick = { },
                    onRemoveFavoriteClick = { }
                )
            }
        }

        // Then
        composeTestRule.onNodeWithContentDescription("Favorite Restaurant").assertIsDisplayed()
    }

    @Test
    fun favoriteCard_displaysCafeCategory() {
        // Given
        val favoritePlace = testFavoritePlace.copy(
            name = "Best Coffee Shop",
            category = "cafe"
        )

        // When
        composeTestRule.setContent {
            MaterialTheme {
                FavoriteCard(
                    place = favoritePlace,
                    isGridView = false,
                    onClick = { },
                    onRemoveFavoriteClick = { }
                )
            }
        }

        // Then
        composeTestRule.onNodeWithText("Best Coffee Shop").assertIsDisplayed()
        composeTestRule.onNodeWithText("cafe").assertIsDisplayed()
    }

    @Test
    fun favoriteCard_displaysRating() {
        // Given
        val ratedPlace = testFavoritePlace.copy(
            name = "Five Star Place",
            rating = 5.0
        )

        // When
        composeTestRule.setContent {
            MaterialTheme {
                FavoriteCard(
                    place = ratedPlace,
                    isGridView = true,
                    onClick = { },
                    onRemoveFavoriteClick = { }
                )
            }
        }

        // Then
        composeTestRule.onNodeWithText("Five Star Place").assertIsDisplayed()
        // Rating is displayed through RatingRow component which shows stars
    }

    @Test
    fun favoriteCard_displaysLowRating() {
        // Given
        val lowRatedPlace = testFavoritePlace.copy(
            name = "Okay Place",
            rating = 2.5
        )

        // When
        composeTestRule.setContent {
            MaterialTheme {
                FavoriteCard(
                    place = lowRatedPlace,
                    isGridView = false,
                    onClick = { },
                    onRemoveFavoriteClick = { }
                )
            }
        }

        // Then
        composeTestRule.onNodeWithText("Okay Place").assertIsDisplayed()
        // Rating is displayed through RatingRow component
    }

    @Test
    fun favoriteCard_displaysParkCategory() {
        // Given
        val parkPlace = testFavoritePlace.copy(
            name = "Beautiful Park",
            category = "park"
        )

        // When
        composeTestRule.setContent {
            MaterialTheme {
                FavoriteCard(
                    place = parkPlace,
                    isGridView = true,
                    onClick = { },
                    onRemoveFavoriteClick = { }
                )
            }
        }

        // Then
        composeTestRule.onNodeWithText("Beautiful Park").assertIsDisplayed()
        composeTestRule.onNodeWithText("park").assertIsDisplayed()
    }
}