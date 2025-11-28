package com.example.habit_tracker.ui.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HabitDetailsScreen(
    habitId: Int,
    onBack: () -> Unit,
    viewModel: HabitDetailsViewModel = viewModel()
) {
    val habit by viewModel.habit.collectAsState()

    LaunchedEffect(habitId) { viewModel.loadHabit(habitId) }

    @OptIn(ExperimentalMaterial3Api::class)
    Scaffold(
        topBar = { TopAppBar(title = { Text("Habit Details") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            habit?.let {
                Text("Title: ${it.title}", style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Description: ${it.description ?: ""}", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Created: ${it.createdAt}", style = MaterialTheme.typography.bodyMedium)
            } ?: Text("Habit not found")
        }
    }
}
