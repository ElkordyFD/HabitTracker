package com.example.habit_tracker

import org.junit.Assert.*
import org.junit.Test

class HabitEntityTest {

    @Test
    fun `habit entity is created with correct title`() {
        val habit = HabitEntity(title = "Drink Water")

        assertEquals("Drink Water", habit.title)
    }

    @Test
    fun `habit entity has default id and createdAt`() {
        val habit = HabitEntity(title = "Read Book")

        assertEquals(0, habit.id)
        assertTrue(habit.createdAt > 0)
    }
}
