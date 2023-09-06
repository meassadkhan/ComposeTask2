package com.example.composetask.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetask.viewmodel.MainViewModel

@Composable
fun NavGraph(viewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "movies_screen") {
        composable("movies_screen") {
            MoviesScreen(viewModel, navController)
        }
        composable(
            route = "detail_screen"
        ) {
            MovieDetailScreen(navController)
        }
    }
}