package com.example.habit_tracker.ui.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habit_tracker.DatabaseProvider
import com.example.habit_tracker.HabitEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HabitDetailsViewModel : ViewModel() {

    private val habitDao = DatabaseProvider.getDatabase().habitDao()

    private val _habit = MutableStateFlow<HabitEntity?>(null)
    val habit: StateFlow<HabitEntity?> = _habit

    fun deleteHabit(habitId: Int, onDeleted: () -> Unit) {
        viewModelScope.launch {
            val habit = habitDao.getHabitById(habitId)
            habit?.let {
                habitDao.deleteHabit(it)
                onDeleted() // ترجع المستخدم للصفحة السابقة بعد الحذف
            }
        }
    }
    fun loadHabit(id: Int) {
        habitDao?.let { dao ->
            viewModelScope.launch {
                _habit.value = dao.getHabitById(id)
            }
        }
    }
}
