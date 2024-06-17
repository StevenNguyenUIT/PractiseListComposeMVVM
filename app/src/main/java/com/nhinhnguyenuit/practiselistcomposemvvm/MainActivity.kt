package com.nhinhnguyenuit.practiselistcomposemvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.compose.rememberNavController
import com.nhinhnguyenuit.practiselistcomposemvvm.navigation.NavGraph
import com.nhinhnguyenuit.practiselistcomposemvvm.ui.screen.ListRestaurantScreen
import com.nhinhnguyenuit.practiselistcomposemvvm.ui.theme.PractiseListComposeMVVMTheme
import com.nhinhnguyenuit.practiselistcomposemvvm.ui.viewmodel.ListRestaurantViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}

@Composable
fun MainScreen(content: @Composable () -> Unit) {
    MaterialTheme{
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PractiseListComposeMVVMTheme {
        MainScreen{}
    }
}