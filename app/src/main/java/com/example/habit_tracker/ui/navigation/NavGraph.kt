package com.example.habit_tracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.habit_tracker.ui.screens.add.AddHabitScreen
import com.example.habit_tracker.ui.screens.details.HabitDetailsScreen
import com.example.habit_tracker.ui.screens.home.HomeScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AddHabit : Screen("add_habit")
    object HabitDetails : Screen("habit_details/{habitId}") {
        fun passId(id: Int) = "habit_details/$id"
    }
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(Screen.Home.route) {
            HomeScreen(
                onAddHabit = { navController.navigate(Screen.AddHabit.route) },
                onHabitClick = { id -> navController.navigate(Screen.HabitDetails.passId(id)) }
            )
        }

        composable(Screen.AddHabit.route) {
            AddHabitScreen(onBack = { navController.popBackStack() })
        }

        composable(Screen.HabitDetails.route) { backStackEntry ->
            val habitId = backStackEntry.arguments?.getString("habitId")?.toInt() ?: 0
            HabitDetailsScreen(
                habitId = habitId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
