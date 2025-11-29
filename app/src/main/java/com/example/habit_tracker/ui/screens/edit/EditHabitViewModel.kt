package com.example.habit_tracker.ui.screens.edit


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habit_tracker.DatabaseProvider
import com.example.habit_tracker.HabitEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EditHabitViewModel : ViewModel() {

    private val habitDao = DatabaseProvider.getDatabase().habitDao()

    private val _habit = MutableStateFlow<HabitEntity?>(null)
    val habit: StateFlow<HabitEntity?> = _habit

    fun loadHabit(id: Int) {
        viewModelScope.launch {
            _habit.value = habitDao.getHabitById(id)
        }
    }

    fun updateHabit(title: String, description: String) {
        val current = _habit.value ?: return

        val updatedHabit = current.copy(
            title = title,
            description = description
        )

        viewModelScope.launch {
            habitDao.updateHabit(updatedHabit)
        }
    }
}
