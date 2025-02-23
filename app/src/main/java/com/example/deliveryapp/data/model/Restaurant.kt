package com.example.deliveryapp.data.model

data class Restaurant(
    val id: Int,
    val name: String,
    val rating: Float,
    val imageUrl: String,
    val menu: List<MenuItem>
)

data class MenuItem(
    val id: Int,
    val name: String,
    val price: Double,
    val description: String
)

data class CartItem(
    @androidx.room.PrimaryKey val id: Int,
    val name: String,
    val price: Double,
    val quantity: Int
)

data class Order(
    val id: Int,
    val items: List<CartItem>,
    val total: Double,
    val status: String
)