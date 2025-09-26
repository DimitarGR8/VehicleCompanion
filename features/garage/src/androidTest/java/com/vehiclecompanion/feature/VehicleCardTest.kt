package com.vehiclecompanion.feature

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.vehiclecompanion.model.VehicleModel
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class VehicleCardTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun vehicleCard_displaysCorrectContent_withAllFields() {
        // Given
        val testVehicle = VehicleModel(
            id = 1L,
            name = "My Tesla",
            make = "Tesla",
            model = "Model 3",
            year = 2023,
            vin = "1HGBH41JXMN109186",
            fuelType = "Electric",
            imageUri = null
        )

        // When
        composeTestRule.setContent {
            MaterialTheme {
                VehicleCard(
                    vehicle = testVehicle,
                    onEditClick = { },
                    onDeleteClick = { }
                )
            }
        }

        // Then
        composeTestRule.onNodeWithText("My Tesla").assertIsDisplayed()
        composeTestRule.onNodeWithText("2023 Tesla Model 3").assertIsDisplayed()
        composeTestRule.onNodeWithText("Electric").assertIsDisplayed()
        composeTestRule.onNodeWithText("VIN: 1HGBH41JXMN109186").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Edit Vehicle").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Delete Vehicle").assertIsDisplayed()
    }

    @Test
    fun vehicleCard_displaysCorrectContent_withoutVin() {
        // Given
        val testVehicle = VehicleModel(
            id = 2L,
            name = "My Honda",
            make = "Honda",
            model = "Civic",
            year = 2020,
            vin = null,
            fuelType = "Gasoline",
            imageUri = null
        )

        // When
        composeTestRule.setContent {
            MaterialTheme {
                VehicleCard(
                    vehicle = testVehicle,
                    onEditClick = { },
                    onDeleteClick = { }
                )
            }
        }

        // Then
        composeTestRule.onNodeWithText("My Honda").assertIsDisplayed()
        composeTestRule.onNodeWithText("2020 Honda Civic").assertIsDisplayed()
        composeTestRule.onNodeWithText("Gasoline").assertIsDisplayed()
        // VIN should not be displayed when null
    }

    @Test
    fun vehicleCard_displaysDefaultCarIcon_whenNoImage() {
        // Given
        val testVehicle = VehicleModel(
            id = 3L,
            name = "Test Vehicle",
            make = "Test",
            model = "Vehicle",
            year = 2022,
            vin = null,
            fuelType = "Gasoline",
            imageUri = null
        )

        // When
        composeTestRule.setContent {
            MaterialTheme {
                VehicleCard(
                    vehicle = testVehicle,
                    onEditClick = { },
                    onDeleteClick = { }
                )
            }
        }

        // Then
        composeTestRule.onNodeWithContentDescription("Default Vehicle").assertIsDisplayed()
    }

    @Test
    fun vehicleCard_displaysVehicleImage_whenImageProvided() {
        // Given
        val testVehicle = VehicleModel(
            id = 4L,
            name = "Car with Image",
            make = "BMW",
            model = "X5",
            year = 2023,
            vin = null,
            fuelType = "Gasoline",
            imageUri = "content://test/image.jpg"
        )

        // When
        composeTestRule.setContent {
            MaterialTheme {
                VehicleCard(
                    vehicle = testVehicle,
                    onEditClick = { },
                    onDeleteClick = { }
                )
            }
        }

        // Then
        composeTestRule.onNodeWithContentDescription("Vehicle Image").assertIsDisplayed()
    }
}