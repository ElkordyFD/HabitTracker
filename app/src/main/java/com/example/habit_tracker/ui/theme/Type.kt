package com.example.habit_tracker.ui.theme


import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


val AppFont = FontFamily.Default

val Typography = Typography(
    titleLarge = androidx.compose.ui.text.TextStyle(
        fontFamily = AppFont,
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold
    ),
    bodyLarge = androidx.compose.ui.text.TextStyle(
        fontFamily = AppFont,
        fontSize = 16.sp
    ),
    bodyMedium = androidx.compose.ui.text.TextStyle(
        fontFamily = AppFont,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    )
)
