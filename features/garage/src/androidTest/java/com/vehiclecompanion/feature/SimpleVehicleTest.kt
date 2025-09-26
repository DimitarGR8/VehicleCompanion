package com.vehiclecompanion.feature

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SimpleVehicleTest {

    @Test
    fun simple_vehicle_test_passes() {
        assertTrue("This test should pass", true)
    }
    
    @Test
    fun another_simple_test() {
        assertEquals("Expected values match", 1, 1)
    }
}