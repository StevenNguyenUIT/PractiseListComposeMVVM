package com.nhinhnguyenuit.practiselistcomposemvvm.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val RETROFIT by lazy {
        Retrofit.Builder()
            .baseUrl("https://restaurants-db-default-rtdb.firebaseio.com/")
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

    val Api by lazy {
        RETROFIT.create(ApiService::class.java)
    }
}