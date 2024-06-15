package com.nhinhnguyenuit.practiselistcomposemvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nhinhnguyenuit.practiselistcomposemvvm.data.model.Restaurant
import com.nhinhnguyenuit.practiselistcomposemvvm.data.repository.RestaurantRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListRestaurantViewModel: ViewModel() {
    private val repository = RestaurantRepository()
    private val _restaurants = MutableStateFlow<List<Restaurant>>(emptyList())
    val restaurants : StateFlow<List<Restaurant>> = _restaurants

    init {
        viewModelScope.launch {
            val restaurants = repository.getRestaurants()
            Log.d("nhinhng","list: $restaurants")
            _restaurants.value = restaurants
        }
    }

}