package com.example.food.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.food.R

// Set of Material typography styles to start with
val FoodTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.sen)),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp),

    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.sen)),
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 16.84.sp),

    bodySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.sen)),
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        lineHeight = 15.64.sp),

    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.sen)),
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 24.06.sp
    ),

    headlineLarge = TextStyle(
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 36.09.sp,
        fontFamily = FontFamily(Font(R.font.sen))),

    headlineSmall = TextStyle(
        fontSize = 16.sp,
    fontWeight = FontWeight.Thin,
    lineHeight = 26.sp,
    fontFamily = FontFamily(Font(R.font.sen)),

)

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)