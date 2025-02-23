package com.example.deliveryapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "restaurants") {
                composable("restaurants") { RestaurantScreen(navController) }
                composable("menu/{restaurantId}") { backStackEntry ->
                    MenuScreen(navController, backStackEntry.arguments?.getString("restaurantId")?.toInt() ?: 0)
                }
                composable("cart") { CartScreen(navController) }
                composable("tracking/{orderId}") { backStackEntry ->
                    TrackingScreen(backStackEntry.arguments?.getString("orderId")?.toInt() ?: 0)
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    RestaurantScreen(rememberNavController())
}