package com.example.deliveryapp.domain

import com.example.deliveryapp.data.Repository
import com.example.deliveryapp.data.model.Restaurant
import javax.inject.Inject

class GetRestaurantsUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(): List<Restaurant> = repository.getRestaurants()
}