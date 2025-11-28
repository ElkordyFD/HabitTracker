package com.example.habit_tracker.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habit_tracker.DatabaseProvider
import com.example.habit_tracker.HabitEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val habitDao = DatabaseProvider.getDatabase().habitDao()

    private val _habits = MutableStateFlow<List<HabitEntity>>(emptyList())
    val habits: StateFlow<List<HabitEntity>> = _habits

    init {
        loadHabits()
    }

     fun deleteHabit(habit: HabitEntity) {
        habitDao?.let { dao ->
            viewModelScope.launch {
                dao.deleteHabit(habit)
            }
        }
    }

    private fun loadHabits() {
        habitDao?.let { dao ->
            viewModelScope.launch {
                dao.getAllHabits().collectLatest { habitList ->
                    _habits.value = habitList
                }
            }
        }
    }
}
