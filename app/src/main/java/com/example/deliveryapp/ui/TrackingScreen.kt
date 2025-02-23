package com.example.deliveryapp.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TrackingScreen(orderId: Int, viewModel: OrderViewModel = hiltViewModel()) {
    val status = viewModel.orderStatus.collectAsState().value ?: "PLACED"
    Text("Order #$orderId Status: $status")
}