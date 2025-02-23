package com.example.deliveryapp.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.deliveryapp.data.model.CartItem

@Composable
fun MenuScreen(navController: NavController, restaurantId: Int, viewModel: OrderViewModel = hiltViewModel()) {
    val restaurant = viewModel.repository.getRestaurants().find { it.id == restaurantId } ?: return

    LazyColumn {
        items(restaurant.menu) { item ->
            Button(onClick = {
                viewModel.addToCart(CartItem(item.id, item.name, item.price, 1))
                navController.navigate("cart")
            }) {
                Text("${item.name} - $${item.price}")
            }
        }
    }
}