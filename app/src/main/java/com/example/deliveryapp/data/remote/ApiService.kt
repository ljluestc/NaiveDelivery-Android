package com.example.deliveryapp.data.remote

import com.example.deliveryapp.data.model.Order
import com.example.deliveryapp.data.model.Restaurant
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("restaurants")
    suspend fun getRestaurants(): List<Restaurant>

    @POST("orders")
    suspend fun placeOrder(@Body order: Order): Order
}