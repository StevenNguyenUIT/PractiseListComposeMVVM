package com.nhinhnguyenuit.practiselistcomposemvvm.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nhinhnguyenuit.practiselistcomposemvvm.data.model.Restaurant
import com.nhinhnguyenuit.practiselistcomposemvvm.data.remote.ApiService
import com.nhinhnguyenuit.practiselistcomposemvvm.data.remote.RetrofitInstance
import java.io.InputStreamReader
import java.io.Reader
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val context: Context
) : ApiService {
    override suspend fun getRestaurants(): List<Restaurant> {
        return RetrofitInstance.Api.getRestaurants()
    }
    suspend fun getRestaurantsLocalLists(): List<Restaurant>{
        return listOf(
            Restaurant(1,"Aaaa", "abasdfsdfsdfsdf adssdf dfdb dfd fd"),
            Restaurant(2,"baaa", "dfsdfsdfsdf adssdf dfdb dfd fd"),
            Restaurant(3,"caaa", "fsdfsdfsdf adssdf dfdb dfd fd"),
            Restaurant(4,"daaa", "sdfsdfsdf adssdf dfdb dfd fd"),
            Restaurant(5,"eaaa", "fsdf adssdf dfdb dfd fd"),
            Restaurant(6,"faaa", "fsfsdf adssdf dfdb dfd fd"),
            Restaurant(7,"faaa", "dfsdfsdf adssdf dfdb dfd fd"),
            Restaurant(8,"faaa", "fsdfsdf adssdf dfdb dfd fd"),
            Restaurant(8,"faaa", "dfsdf adssdf dfdb dfd fd"),
            Restaurant(10,"faaa", "sdfsdf adssdf dfdb dfd fd"),
            Restaurant(11,"faaa", "fsdf adssdf dfdb dfd fd"),
        )
    }
    suspend fun getRestaurantsJson(): List<Restaurant>{
        val inputStream = context.resources.openRawResource(
            com.nhinhnguyenuit.practiselistcomposemvvm.R.raw.itemlist
        )
        val reader = InputStreamReader(inputStream)
        val itemType = object : TypeToken<List<Restaurant>>() {}.type
        return Gson().fromJson(reader, itemType)
    }

    suspend fun getRestaurantsJson2(): List<Restaurant>{
        val jsonString = context.assets.open("itemlist.json").bufferedReader().use { it.readText()}
        return Gson().fromJson(jsonString, Array<Restaurant>::class.java).toList()
    }

}