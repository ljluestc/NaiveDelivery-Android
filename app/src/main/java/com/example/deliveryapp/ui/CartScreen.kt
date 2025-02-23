package com.example.deliveryapp.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun CartScreen(navController: NavController, viewModel: OrderViewModel = hiltViewModel()) {
    val cartItems = viewModel.cartItems.collectAsState().value

    LazyColumn {
        items(cartItems) { item ->
            Text("${item.name} x${item.quantity} - $${item.price * item.quantity}")
        }
        item {
            Button(onClick = {
                viewModel.placeOrder()
                navController.navigate("tracking/${(0..1000).random()}")
            }) {
                Text("Place Order")
            }
        }
    }
}