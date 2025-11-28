package com.example.habit_tracker.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun HomeScreen(
    onAddHabit: () -> Unit,
    onHabitClick: (Int) -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    val habits by viewModel.habits.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddHabit) {
                Text("+")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text("Your Habits", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))

            habits.forEach { habit ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // جزء Habit نفسه
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { onHabitClick(habit.id) }
                        ) {
                            Text(habit.title, style = MaterialTheme.typography.titleLarge)
                            Text(habit.description ?: "", style = MaterialTheme.typography.bodyMedium)
                        }

                        // زر الحذف
                        IconButton(onClick = { viewModel.deleteHabit(habit) }) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete Habit"
                            )
                        }
                    }
                }
            }
        }
    }
}
