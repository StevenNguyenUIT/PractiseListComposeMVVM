package com.nhinhnguyenuit.practiselistcomposemvvm.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.nhinhnguyenuit.practiselistcomposemvvm.data.model.Restaurant
import com.nhinhnguyenuit.practiselistcomposemvvm.navigation.SCREEN
import com.nhinhnguyenuit.practiselistcomposemvvm.ui.viewmodel.ListRestaurantViewModel


@Composable
fun ListRestaurantScreen(
    navController: NavHostController,
    viewModel: ListRestaurantViewModel
){
    val restaurants by viewModel.restaurants.collectAsState()

    LazyColumn(
        modifier = Modifier.padding(0.dp)
    ) {
        items(restaurants){ res ->
            RestaurantItem(res, onItemClick = {navController.navigate("itemdetail/${it}")})
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantItem(res: Restaurant, onItemClick: (Int) -> Unit) {
    Card(onClick = { onItemClick(res.id) },
        modifier = Modifier.padding(20.dp)
        ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(text = res.title, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = res.description, style = MaterialTheme.typography.titleMedium)
        }
    }
}

