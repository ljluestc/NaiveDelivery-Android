package com.example.deliveryapp.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun RestaurantScreen(navController: NavController, viewModel: RestaurantViewModel = hiltViewModel()) {
    val restaurants = viewModel.restaurants.collectAsState().value

    LazyColumn {
        items(restaurants) { restaurant ->
            Button(onClick = { navController.navigate("menu/${restaurant.id}") }) {
                Text(restaurant.name)
            }
        }
    }
}