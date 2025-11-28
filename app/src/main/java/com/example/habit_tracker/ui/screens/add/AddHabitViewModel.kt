package com.example.habit_tracker.ui.screens.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habit_tracker.DatabaseProvider
import com.example.habit_tracker.HabitEntity
import kotlinx.coroutines.launch

class AddHabitViewModel : ViewModel() {

    private val habitDao = DatabaseProvider.getDatabase().habitDao()

    fun addHabit(title: String, description: String) {
        habitDao?.let { dao ->
            viewModelScope.launch {
                dao.insertHabit(HabitEntity(title = title, description = description))
            }
        }
    }
}
