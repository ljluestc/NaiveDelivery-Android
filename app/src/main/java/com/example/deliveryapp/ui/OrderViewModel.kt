package com.example.deliveryapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryapp.data.Repository
import com.example.deliveryapp.data.model.CartItem
import com.example.deliveryapp.data.model.Order
import com.example.deliveryapp.domain.AddToCartUseCase
import com.example.deliveryapp.domain.PlaceOrderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val addToCartUseCase: AddToCartUseCase,
    private val placeOrderUseCase: PlaceOrderUseCase,
    private val repository: Repository
) : ViewModel() {
    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems

    private val _orderStatus = MutableStateFlow<String?>(null)
    val orderStatus: StateFlow<String?> = _orderStatus

    init {
        loadCart()
    }

    fun addToCart(item: CartItem) {
        viewModelScope.launch {
            addToCartUseCase(item)
            loadCart()
        }
    }

    fun placeOrder() {
        viewModelScope.launch {
            val items = _cartItems.value
            val total = items.sumOf { it.price * it.quantity }
            val order = Order((0..1000).random(), items, total, "PLACED")
            val result = placeOrderUseCase(order)
            _orderStatus.value = result.status
            repository.clearCart()
            loadCart()
        }
    }

    private fun loadCart() {
        viewModelScope.launch {
            _cartItems.value = repository.getCartItems()
        }
    }
}