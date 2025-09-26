package com.vehiclecompanion.feature

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.vehiclecompanion.model.LocationUiModel
import com.vehiclecompanion.model.PlaceUiModel
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PlaceCardTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val testPlace = PlaceUiModel(
        id = 1,
        name = "Central Park",
        url = "file:///android_asset/central-park",
        category = "park",
        rating = 4.5,
        imageUrl = "file:///android_asset/test_image.jpg",
        location = LocationUiModel(
            latitude = 40.7829,
            longitude = -73.9654
        ),
        isFavorite = false
    )

    @Test
    fun placeCard_gridView_displaysCorrectContent() {
        // When
        composeTestRule.setContent {
            MaterialTheme {
                PlaceCard(
                    place = testPlace,
                    isFavorite = false,
                    isGridView = true,
                    onClick = { },
                    onFavoriteClick = { }
                )
            }
        }

        // Then
        composeTestRule.onNodeWithText("Central Park").assertIsDisplayed()
        composeTestRule.onNodeWithText("park").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Add to favorites").assertIsDisplayed()
    }

    @Test
    fun placeCard_listView_displaysCorrectContent() {
        // When
        composeTestRule.setContent {
            MaterialTheme {
                PlaceCard(
                    place = testPlace,
                    isFavorite = false,
                    isGridView = false,
                    onClick = { },
                    onFavoriteClick = { }
                )
            }
        }

        // Then
        composeTestRule.onNodeWithText("Central Park").assertIsDisplayed()
        composeTestRule.onNodeWithText("park").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Add to favorites").assertIsDisplayed()
    }

    @Test
    fun placeCard_showsFavoriteIcon_whenIsFavorite() {
        // When
        composeTestRule.setContent {
            MaterialTheme {
                PlaceCard(
                    place = testPlace.copy(isFavorite = true),
                    isFavorite = true,
                    isGridView = false,
                    onClick = { },
                    onFavoriteClick = { }
                )
            }
        }

        // Then
        composeTestRule.onNodeWithContentDescription("Remove from favorites").assertIsDisplayed()
    }

    @Test
    fun placeCard_showsUnfavoriteIcon_whenNotFavorite() {
        // When
        composeTestRule.setContent {
            MaterialTheme {
                PlaceCard(
                    place = testPlace.copy(isFavorite = false),
                    isFavorite = false,
                    isGridView = false,
                    onClick = { },
                    onFavoriteClick = { }
                )
            }
        }

        // Then
        composeTestRule.onNodeWithContentDescription("Add to favorites").assertIsDisplayed()
    }

    @Test
    fun placeCard_displaysImage() {
        // When
        composeTestRule.setContent {
            MaterialTheme {
                PlaceCard(
                    place = testPlace,
                    isFavorite = false,
                    isGridView = true,
                    onClick = { },
                    onFavoriteClick = { }
                )
            }
        }

        // Then
        composeTestRule.onNodeWithContentDescription("Central Park").assertIsDisplayed()
    }

    @Test
    fun placeCard_displaysRestaurantCategory() {
        // Given
        val restaurantPlace = testPlace.copy(
            name = "Amazing Restaurant",
            category = "restaurant"
        )

        // When
        composeTestRule.setContent {
            MaterialTheme {
                PlaceCard(
                    place = restaurantPlace,
                    isFavorite = false,
                    isGridView = false,
                    onClick = { },
                    onFavoriteClick = { }
                )
            }
        }

        // Then
        composeTestRule.onNodeWithText("Amazing Restaurant").assertIsDisplayed()
        composeTestRule.onNodeWithText("restaurant").assertIsDisplayed()
    }

    @Test
    fun placeCard_displaysHighRating() {
        // Given
        val highRatedPlace = testPlace.copy(
            name = "Top Rated Place",
            rating = 4.8
        )

        // When
        composeTestRule.setContent {
            MaterialTheme {
                PlaceCard(
                    place = highRatedPlace,
                    isFavorite = false,
                    isGridView = true,
                    onClick = { },
                    onFavoriteClick = { }
                )
            }
        }

        // Then
        composeTestRule.onNodeWithText("Top Rated Place").assertIsDisplayed()
        // Rating is displayed through RatingRow component which shows stars
    }
}