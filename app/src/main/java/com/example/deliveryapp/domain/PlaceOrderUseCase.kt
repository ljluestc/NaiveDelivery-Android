package com.example.deliveryapp.domain

import com.example.deliveryapp.data.Repository
import com.example.deliveryapp.data.model.Order
import javax.inject.Inject

class PlaceOrderUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(order: Order): Order = repository.placeOrder(order)
}