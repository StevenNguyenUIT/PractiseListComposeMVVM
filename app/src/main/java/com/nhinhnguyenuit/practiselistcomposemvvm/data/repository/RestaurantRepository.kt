package com.nhinhnguyenuit.practiselistcomposemvvm.data.repository

import com.nhinhnguyenuit.practiselistcomposemvvm.data.model.Restaurant
import com.nhinhnguyenuit.practiselistcomposemvvm.data.remote.ApiService
import com.nhinhnguyenuit.practiselistcomposemvvm.data.remote.RetrofitInstance

class RestaurantRepository : ApiService {
    override suspend fun getRestaurants(): List<Restaurant> {
        return RetrofitInstance.Api.getRestaurants()
    }
}