package com.example.deliveryapp.domain

import com.example.deliveryapp.data.Repository
import com.example.deliveryapp.data.model.CartItem
import javax.inject.Inject

class AddToCartUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(item: CartItem) = repository.addToCart(item)
}