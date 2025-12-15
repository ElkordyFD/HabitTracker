package com.example.habit_tracker

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.assertIsDisplayed


@RunWith(AndroidJUnit4::class)
class SimpleEspressoTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    // ✅ تأكد من ظهور زر الـ Add
    @Test
    fun testFloatingActionButtonIsDisplayed() {
        composeTestRule.onNodeWithTag("addHabitButton")
            .assertIsDisplayed()
    }


}
