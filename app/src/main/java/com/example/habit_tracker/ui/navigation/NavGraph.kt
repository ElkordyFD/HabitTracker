package com.example.habit_tracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.example.habit_tracker.ui.screens.add.AddHabitScreen
import com.example.habit_tracker.ui.screens.details.HabitDetailsScreen
import com.example.habit_tracker.ui.screens.edit.EditHabitScreen
import com.example.habit_tracker.ui.screens.home.HomeScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AddHabit : Screen("add_habit")
    object HabitDetails : Screen("habit_details/{habitId}") {
        fun passId(id: Int) = "habit_details/$id"
    }
    object EditHabit : Screen("edit/{habitId}") {
        fun passId(id: Int) = "edit/$id"
    }
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {

        // Home Screen
        composable(Screen.Home.route) {
            HomeScreen(
                onAddHabit = { navController.navigate(Screen.AddHabit.route) },
                onHabitClick = { id -> navController.navigate(Screen.HabitDetails.passId(id)) },
                onEdit = { id -> navController.navigate(Screen.EditHabit.passId(id)) }

            )
        }

        // Add Habit Screen
        composable(Screen.AddHabit.route) {
            AddHabitScreen(onBack = { navController.popBackStack() })
        }

        // Habit Details Screen
        composable(
            route = Screen.HabitDetails.route,
            arguments = listOf(navArgument("habitId") { type = NavType.IntType })
        ) { backStackEntry ->
            val habitId = backStackEntry.arguments?.getInt("habitId") ?: 0
            HabitDetailsScreen(
                habitId = habitId,
                onBack = { navController.popBackStack() },
                onEdit = { id ->
                    navController.navigate(Screen.EditHabit.passId(id))
                }
            )
        }

        // Edit Habit Screen
        composable(
            route = Screen.EditHabit.route,
            arguments = listOf(navArgument("habitId") { type = NavType.IntType })
        ) { backStackEntry ->
            val habitId = backStackEntry.arguments?.getInt("habitId") ?: 0
            EditHabitScreen(
                habitId = habitId,
                onBack = { navController.popBackStack() }
            )
        }

    }
}
