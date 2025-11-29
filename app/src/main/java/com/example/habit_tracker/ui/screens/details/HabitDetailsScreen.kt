package com.example.habit_tracker.ui.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitDetailsScreen(
    habitId: Int,
    onBack: () -> Unit,
    onEdit: (Int) -> Unit,
    viewModel: HabitDetailsViewModel = viewModel()
) {
    val habit by viewModel.habit.collectAsState()

    // Load habit data
    LaunchedEffect(habitId) {
        viewModel.loadHabit(habitId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Habit Details") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            habit?.let { h ->
                Text(
                    text = "${h.title}",
                    style = MaterialTheme.typography.headlineSmall
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "${h.description ?: ""}",
                    style = MaterialTheme.typography.bodyLarge
                )


                Spacer(modifier = Modifier.height(16.dp))

            } ?: Text("Habit not found")
        }
    }
}
