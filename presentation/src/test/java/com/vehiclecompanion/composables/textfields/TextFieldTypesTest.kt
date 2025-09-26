package com.vehiclecompanion.composables.textfields

import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import org.junit.Assert.*
import org.junit.Test

class TextFieldTypesTest {

    @Test
    fun `VEHICLE_YEAR should only accept numeric input`() {
        val vehicleYearType = TextFieldTypes.VEHICLE_YEAR

        // Valid inputs
        assertTrue("2020".matches(vehicleYearType.regexPattern))
        assertTrue("2023".matches(vehicleYearType.regexPattern))
        assertTrue("1999".matches(vehicleYearType.regexPattern))
        assertTrue("0".matches(vehicleYearType.regexPattern))
        assertTrue("123".matches(vehicleYearType.regexPattern))

        // Invalid inputs (letters)
        assertFalse("2020a".matches(vehicleYearType.regexPattern))
        assertFalse("abc".matches(vehicleYearType.regexPattern))
        assertFalse("20a0".matches(vehicleYearType.regexPattern))
        assertFalse("year".matches(vehicleYearType.regexPattern))

        // Invalid inputs (special characters)
        assertFalse("2020!".matches(vehicleYearType.regexPattern))
        assertFalse("20-20".matches(vehicleYearType.regexPattern))
        assertFalse("2020.".matches(vehicleYearType.regexPattern))
        assertFalse("2020 ".matches(vehicleYearType.regexPattern))

        // Invalid inputs (too long)
        assertFalse("20200".matches(vehicleYearType.regexPattern))
        assertFalse("123456".matches(vehicleYearType.regexPattern))
    }

    @Test
    fun `VEHICLE_YEAR should have correct keyboard configuration`() {
        val vehicleYearType = TextFieldTypes.VEHICLE_YEAR

        assertEquals(KeyboardType.Number, vehicleYearType.keyboardType)
        assertEquals(ImeAction.Next, vehicleYearType.imeAction)
    }

    @Test
    fun `VEHICLE_YEAR should allow empty input`() {
        val vehicleYearType = TextFieldTypes.VEHICLE_YEAR
        assertTrue("".matches(vehicleYearType.regexPattern))
    }

    @Test
    fun `VEHICLE_YEAR should limit to 4 digits maximum`() {
        val vehicleYearType = TextFieldTypes.VEHICLE_YEAR

        // Exactly 4 digits - should be valid
        assertTrue("1234".matches(vehicleYearType.regexPattern))
        assertTrue("2024".matches(vehicleYearType.regexPattern))

        // More than 4 digits - should be invalid
        assertFalse("12345".matches(vehicleYearType.regexPattern))
        assertFalse("202024".matches(vehicleYearType.regexPattern))
    }

    @Test
    fun `ADD_VEHICLE_NUMBER should still work for VIN`() {
        val vinType = TextFieldTypes.ADD_VEHICLE_NUMBER

        // Valid VIN patterns
        assertTrue("1HGBH41JXMN1".matches(vinType.regexPattern))
        assertTrue("ABC123DEF456".matches(vinType.regexPattern))
        assertTrue("".matches(vinType.regexPattern))

        // Invalid VIN patterns
        assertFalse("1hgbh41jxmn1".matches(vinType.regexPattern)) // lowercase
        assertFalse("1HGBH41JXMN12345".matches(vinType.regexPattern)) // too long
        assertFalse("1HGBH41JXMN!".matches(vinType.regexPattern)) // special chars
    }
}
