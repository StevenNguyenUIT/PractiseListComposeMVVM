package com.nhinhnguyenuit.practiselistcomposemvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavArgument
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.nhinhnguyenuit.practiselistcomposemvvm.ui.screen.ItemDetailScreen
import com.nhinhnguyenuit.practiselistcomposemvvm.ui.screen.ListRestaurantScreen
import com.nhinhnguyenuit.practiselistcomposemvvm.ui.viewmodel.ListRestaurantViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = SCREEN.listScreen.route) {
        composable(SCREEN.listScreen.route) {
            ListRestaurantScreen(
                navController = navController,
                onItemClick = { navController.navigate("itemdetail/${it}") }
            )
        }
        composable(
            SCREEN.detailScreen.route,
            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("itemId") ?: 0
            ItemDetailScreen(id = id)
        }
    }
}