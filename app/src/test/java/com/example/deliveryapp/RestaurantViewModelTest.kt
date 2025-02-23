package com.example.deliveryapp

import com.example.deliveryapp.data.Repository
import com.example.deliveryapp.data.model.Restaurant
import com.example.deliveryapp.domain.GetRestaurantsUseCase
import com.example.deliveryapp.ui.RestaurantViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

@ExperimentalCoroutinesApi
class RestaurantViewModelTest {
    private lateinit var viewModel: RestaurantViewModel
    private lateinit var repository: Repository
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        repository = Mockito.mock(Repository::class.java)
        viewModel = RestaurantViewModel(GetRestaurantsUseCase(repository))
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadRestaurants updates restaurants`() = runTest {
        val restaurants = listOf(Restaurant(1, "Test", 4.5f, "", emptyList()))
        `when`(repository.getRestaurants()).thenReturn(restaurants)
        advanceUntilIdle()
        assert(viewModel.restaurants.value == restaurants)
    }
}