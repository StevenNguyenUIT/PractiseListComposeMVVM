package com.nhinhnguyenuit.practiselistcomposemvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.compose.rememberNavController
import com.nhinhnguyenuit.practiselistcomposemvvm.navigation.NavGraph
import com.nhinhnguyenuit.practiselistcomposemvvm.ui.screen.ListRestaurantScreen
import com.nhinhnguyenuit.practiselistcomposemvvm.ui.theme.PractiseListComposeMVVMTheme
import com.nhinhnguyenuit.practiselistcomposemvvm.ui.viewmodel.ListRestaurantViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val viewModel: ListRestaurantViewModel = viewModel()
    val navController  = rememberNavController()
    NavGraph(viewModel = viewModel, navController = navController)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PractiseListComposeMVVMTheme {
        MainScreen()
    }
}