package com.nhinhnguyenuit.practiselistcomposemvvm.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nhinhnguyenuit.practiselistcomposemvvm.ui.viewmodel.ListRestaurantViewModel

@Composable
fun ItemDetailScreen(
    id: Int,
    viewModel: ListRestaurantViewModel = hiltViewModel()
){
    val restaurants by viewModel.restaurants.collectAsState()
    val restaurant = restaurants.find { it.id==id }
    Log.d("nhinhng","item: $restaurant")
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        restaurant?.let {
            Column{
                Text(text = it.title, style = MaterialTheme.typography.titleLarge )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = it.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}