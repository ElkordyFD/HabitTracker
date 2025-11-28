package com.example.habit_tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.habit_tracker.ui.navigation.NavGraph
import com.example.habit_tracker.ui.theme.HabitTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DatabaseProvider.init(this)

        setContent {
            HabitTrackerTheme {
                val navController = rememberNavController()
                NavGraph(navController)
            }
        }
    }
}
