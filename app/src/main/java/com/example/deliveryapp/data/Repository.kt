package com.example.deliveryapp.data

import com.example.deliveryapp.data.local.CartDao
import com.example.deliveryapp.data.model.CartItem
import com.example.deliveryapp.data.model.Order
import com.example.deliveryapp.data.model.Restaurant
import com.example.deliveryapp.data.remote.ApiService
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService,
    private val cartDao: CartDao
) {
    suspend fun getRestaurants(): List<Restaurant> {
        // Simulated data
        return listOf(
            Restaurant(1, "Pizza Place", 4.5f, "", listOf(MenuItem(1, "Margherita", 10.0, "Classic pizza"))),
            Restaurant(2, "Sushi Spot", 4.8f, "", listOf(MenuItem(2, "California Roll", 8.0, "Sushi roll")))
        )
    }

    suspend fun addToCart(item: CartItem) = cartDao.addToCart(item)

    suspend fun getCartItems(): List<CartItem> = cartDao.getCartItems()

    suspend fun placeOrder(order: Order): Order {
        // Simulated response
        return Order(order.id, order.items, order.total, "PLACED")
    }

    suspend fun clearCart() = cartDao.clearCart()
}