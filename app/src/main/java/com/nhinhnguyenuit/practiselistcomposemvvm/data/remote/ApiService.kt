package com.nhinhnguyenuit.practiselistcomposemvvm.data.remote

import com.nhinhnguyenuit.practiselistcomposemvvm.data.model.Restaurant
import retrofit2.http.GET

interface ApiService {
    @GET("restaurants.json")
    suspend fun getRestaurants() : List<Restaurant>
}