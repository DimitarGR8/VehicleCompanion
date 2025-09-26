package com.vehiclecompanion.model

import org.junit.Assert.*
import org.junit.Test

class VehicleDataClassTest {

    @Test
    fun `vehicle creation with all required fields should succeed`() {
        val vehicle = VehicleModel(
            id = 1L,
            name = "My Honda",
            make = "Honda",
            model = "Civic",
            year = 2020,
            vin = "1HGBH41JXMN109186",
            fuelType = "Gasoline",
            imageUri = "content://media/external/images/1"
        )

        assertEquals(1L, vehicle.id)
        assertEquals("My Honda", vehicle.name)
        assertEquals("Honda", vehicle.make)
        assertEquals("Civic", vehicle.model)
        assertEquals(2020, vehicle.year)
        assertEquals("1HGBH41JXMN109186", vehicle.vin)
        assertEquals("Gasoline", vehicle.fuelType)
        assertEquals("content://media/external/images/1", vehicle.imageUri)
    }

    @Test
    fun `vehicle creation with minimum required fields should succeed`() {
        val vehicle = VehicleModel(
            id = 0L,
            name = "Test Vehicle",
            make = "Toyota",
            model = "Camry",
            year = 2023,
            vin = null,
            fuelType = "Hybrid",
            imageUri = null
        )

        assertEquals(0L, vehicle.id)
        assertEquals("Test Vehicle", vehicle.name)
        assertEquals("Toyota", vehicle.make)
        assertEquals("Camry", vehicle.model)
        assertEquals(2023, vehicle.year)
        assertNull(vehicle.vin)
        assertEquals("Hybrid", vehicle.fuelType)
        assertNull(vehicle.imageUri)
    }

    @Test
    fun `vehicle with default id should be zero`() {
        val vehicle = VehicleModel(
            name = "New Car",
            make = "Ford",
            model = "F-150",
            year = 2024,
            vin = null,
            fuelType = "Gasoline",
            imageUri = null
        )

        assertEquals(0L, vehicle.id)
    }

    @Test
    fun `vehicle data class equality should work correctly`() {
        val vehicle1 = VehicleModel(
            id = 1L,
            name = "Car One",
            make = "BMW",
            model = "X5",
            year = 2022,
            vin = "WBAFR9C58BC123456",
            fuelType = "Gasoline",
            imageUri = null
        )

        val vehicle2 = VehicleModel(
            id = 1L,
            name = "Car One",
            make = "BMW",
            model = "X5",
            year = 2022,
            vin = "WBAFR9C58BC123456",
            fuelType = "Gasoline",
            imageUri = null
        )

        assertEquals(vehicle1, vehicle2)
        assertEquals(vehicle1.hashCode(), vehicle2.hashCode())
    }

    @Test
    fun `vehicle data class copy should work correctly`() {
        val originalVehicle = VehicleModel(
            id = 1L,
            name = "Original",
            make = "Nissan",
            model = "Altima",
            year = 2021,
            vin = "1N4AL3AP5MC123456",
            fuelType = "Gasoline",
            imageUri = null
        )

        val copiedVehicle = originalVehicle.copy(
            name = "Updated Name",
            year = 2022
        )

        assertEquals(1L, copiedVehicle.id)
        assertEquals("Updated Name", copiedVehicle.name)
        assertEquals("Nissan", copiedVehicle.make)
        assertEquals("Altima", copiedVehicle.model)
        assertEquals(2022, copiedVehicle.year)
        assertEquals("1N4AL3AP5MC123456", copiedVehicle.vin)
        assertEquals("Gasoline", copiedVehicle.fuelType)
        assertNull(copiedVehicle.imageUri)
    }

    @Test
    fun `vehicle toString should contain all field information`() {
        val vehicle = VehicleModel(
            id = 5L,
            name = "Test Car",
            make = "Mercedes",
            model = "C-Class",
            year = 2023,
            vin = "WDDGF4HB7DA123456",
            fuelType = "Diesel",
            imageUri = "file://test.jpg"
        )

        val vehicleString = vehicle.toString()

        assertTrue(vehicleString.contains("id=5"))
        assertTrue(vehicleString.contains("name=Test Car"))
        assertTrue(vehicleString.contains("make=Mercedes"))
        assertTrue(vehicleString.contains("model=C-Class"))
        assertTrue(vehicleString.contains("year=2023"))
        assertTrue(vehicleString.contains("vin=WDDGF4HB7DA123456"))
        assertTrue(vehicleString.contains("fuelType=Diesel"))
        assertTrue(vehicleString.contains("imageUri=file://test.jpg"))
    }

    @Test
    fun `vehicle with different fuel types should be valid`() {
        val gasolineVehicle = VehicleModel(
            name = "Gas Car",
            make = "Chevrolet",
            model = "Malibu",
            year = 2023,
            vin = null,
            fuelType = "Gasoline",
            imageUri = null
        )

        val electricVehicle = VehicleModel(
            name = "Electric Car",
            make = "Tesla",
            model = "Model 3",
            year = 2023,
            vin = null,
            fuelType = "Electric",
            imageUri = null
        )

        val hybridVehicle = VehicleModel(
            name = "Hybrid Car",
            make = "Prius",
            model = "Prime",
            year = 2023,
            vin = null,
            fuelType = "Hybrid",
            imageUri = null
        )

        assertEquals("Gasoline", gasolineVehicle.fuelType)
        assertEquals("Electric", electricVehicle.fuelType)
        assertEquals("Hybrid", hybridVehicle.fuelType)
    }

    @Test
    fun `vehicle with valid year range should be accepted`() {
        val oldVehicle = VehicleModel(
            name = "Classic Car",
            make = "Ford",
            model = "Mustang",
            year = 1970,
            vin = null,
            fuelType = "Gasoline",
            imageUri = null
        )

        val newVehicle = VehicleModel(
            name = "New Car",
            make = "Audi",
            model = "A4",
            year = 2024,
            vin = null,
            fuelType = "Gasoline",
            imageUri = null
        )

        assertEquals(1970, oldVehicle.year)
        assertEquals(2024, newVehicle.year)
    }
}
