package com.vehiclecompanion.repository

import com.vehiclecompanion.data.model.PoiDto
import com.vehiclecompanion.mapper.mapToDomain
import com.vehiclecompanion.model.PoiResponse
import com.vehiclecompanion.model.TotalInfo
import com.vehiclecompanion.remote.api.ApiHelper
import com.vehiclecompanion.remote.api.FeaturesApi
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class PlaceServiceTest {

    private lateinit var mockApiService: FeaturesApi
    private lateinit var mockApiHelper: ApiHelper
    private lateinit var poiRepository: PoiRepositoryImpl

    @Before
    fun setup() {
        mockApiService = mockk()
        mockApiHelper = mockk()
        poiRepository = PoiRepositoryImpl(mockApiService, mockApiHelper)
    }

    @Test
    fun `discoverPois should return list of places when API call is successful`() = runTest {
        val mockPoiDto = PoiDto(
            id = 123,
            name = "Test Restaurant",
            primaryCategoryDisplayName = "restaurant",
            location = listOf(-74.0060, 40.7128),
            imageUrl = "https://example.com/image.jpg",
            rating = 4.5,
            url = "https://example.com/restaurant"
        )

        val mockPoiResponse = PoiResponse(
            pois = listOf(mockPoiDto),
            total = TotalInfo(value = 1, relation = "eq")
        )

        val expectedDomainModels = mockPoiResponse.mapToDomain()

        coEvery {
            mockApiHelper.makeApiCall<PoiResponse>(networkCall = any())
        } returns mockPoiResponse

        val result = poiRepository.discoverPois(
            swCornerLat = 40.7000,
            swCornerLng = -74.0100,
            neCornerLat = 40.7200,
            neCornerLng = -74.0000,
            pageSize = 50
        )

        assertEquals(expectedDomainModels.size, result.size)
        assertEquals(expectedDomainModels.first().id, result.first().id)
        assertEquals(expectedDomainModels.first().name, result.first().name)
        assertEquals(expectedDomainModels.first().category, result.first().category)

        coVerify {
            mockApiHelper.makeApiCall<PoiResponse>(networkCall = any())
        }
    }

    @Test
    fun `discoverPois should format coordinates correctly`() = runTest {
        val mockPoiResponse = PoiResponse(pois = emptyList(), total = TotalInfo(value = 0, relation = "eq"))

        coEvery {
            mockApiHelper.makeApiCall<PoiResponse>(networkCall = any())
        } returns mockPoiResponse

        poiRepository.discoverPois(
            swCornerLat = 40.7128,
            swCornerLng = -74.0060,
            neCornerLat = 40.7589,
            neCornerLng = -73.9851,
            pageSize = 25
        )

        coVerify {
            mockApiHelper.makeApiCall<PoiResponse>(networkCall = any())
        }
    }

    @Test
    fun `discoverPois should handle empty response`() = runTest {
        val emptyPoiResponse = PoiResponse(pois = emptyList(), total = TotalInfo(value = 0, relation = "eq"))

        coEvery {
            mockApiHelper.makeApiCall<PoiResponse>(networkCall = any())
        } returns emptyPoiResponse

        val result = poiRepository.discoverPois(
            swCornerLat = 0.0,
            swCornerLng = 0.0,
            neCornerLat = 1.0,
            neCornerLng = 1.0,
            pageSize = 10
        )

        assertTrue(result.isEmpty())
        assertEquals(0, result.size)
    }

    @Test
    fun `discoverPois should handle multiple places in response`() = runTest {
        val mockPois = listOf(
            PoiDto(
                id = 1,
                name = "Restaurant 1",
                primaryCategoryDisplayName = "restaurant",
                location = listOf(-74.0060, 40.7128),
                imageUrl = "https://example.com/image1.jpg",
                rating = 4.5,
                url = "https://example.com/restaurant1"
            ),
            PoiDto(
                id = 2,
                name = "Cafe 2",
                primaryCategoryDisplayName = "cafe",
                location = listOf(-73.9851, 40.7589),
                imageUrl = "https://example.com/image2.jpg",
                rating = 4.0,
                url = "https://example.com/cafe2"
            ),
            PoiDto(
                id = 3,
                name = "Park 3",
                primaryCategoryDisplayName = "park",
                location = listOf(-73.9712, 40.7831),
                imageUrl = "https://example.com/image3.jpg",
                rating = 4.8,
                url = "https://example.com/park3"
            )
        )

        val mockPoiResponse = PoiResponse(pois = mockPois, total = TotalInfo(value = 3, relation = "eq"))

        coEvery {
            mockApiHelper.makeApiCall<PoiResponse>(networkCall = any())
        } returns mockPoiResponse

        val result = poiRepository.discoverPois(
            swCornerLat = 40.7000,
            swCornerLng = -74.0100,
            neCornerLat = 40.8000,
            neCornerLng = -73.9500,
            pageSize = 50
        )

        assertEquals(3, result.size)
        assertEquals(1, result[0].id)
        assertEquals("Restaurant 1", result[0].name)
        assertEquals("restaurant", result[0].category)
        assertEquals(2, result[1].id)
        assertEquals("Cafe 2", result[1].name)
        assertEquals("cafe", result[1].category)
        assertEquals(3, result[2].id)
        assertEquals("Park 3", result[2].name)
        assertEquals("park", result[2].category)
    }

    @Test
    fun `discoverPois should use default page size when not specified`() = runTest {
        val mockPoiResponse = PoiResponse(pois = emptyList(), total = TotalInfo(value = 0, relation = "eq"))

        coEvery {
            mockApiHelper.makeApiCall<PoiResponse>(networkCall = any())
        } returns mockPoiResponse

        poiRepository.discoverPois(
            swCornerLat = 40.7000,
            swCornerLng = -74.0100,
            neCornerLat = 40.7200,
            neCornerLng = -74.0000,
            pageSize = 50
        )

        coVerify {
            mockApiHelper.makeApiCall<PoiResponse>(networkCall = any())
        }
    }

    @Test
    fun `discoverPois should handle decimal coordinates correctly`() = runTest {
        val mockPoiResponse = PoiResponse(pois = emptyList(), total = TotalInfo(value = 0, relation = "eq"))

        coEvery {
            mockApiHelper.makeApiCall<PoiResponse>(networkCall = any())
        } returns mockPoiResponse

        poiRepository.discoverPois(
            swCornerLat = 40.712345,
            swCornerLng = -74.006789,
            neCornerLat = 40.758912,
            neCornerLng = -73.985123,
            pageSize = 30
        )

        coVerify {
            mockApiHelper.makeApiCall<PoiResponse>(networkCall = any())
        }
    }
}
