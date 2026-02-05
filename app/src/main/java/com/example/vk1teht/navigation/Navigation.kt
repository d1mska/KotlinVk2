package com.example.vk1teht.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vk1teht.View.Calendar
import com.example.vk1teht.View.HomeScreen
import com.example.vk1teht.viewmodel.TaskViewModel

const val ROUTE_HOME = "home"
const val ROUTE_CALENDAR = "calendar"


@Composable
fun Navigation() {
    val navController = rememberNavController()
    val taskViewModel: TaskViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController, taskViewModel)
        }
        composable(route = Screen.Calendar.route) {
            Calendar(navController, taskViewModel)
        }
    }
}
