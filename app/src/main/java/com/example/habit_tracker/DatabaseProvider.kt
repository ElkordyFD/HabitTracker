package com.example.habit_tracker

import android.content.Context
import androidx.room.Room

object DatabaseProvider {

    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun init(context: Context) {
        if (INSTANCE == null) {
            synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "habits_db"
                ).build()
            }
        }
    }

    fun getDatabase(): AppDatabase {
        return INSTANCE ?: throw IllegalStateException("Database not initialized")
    }
}
