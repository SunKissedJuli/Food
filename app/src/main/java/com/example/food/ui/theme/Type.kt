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
    displayLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.sen)),
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 33.69.sp),

    displayMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.sen)),
        fontWeight = FontWeight.Medium,
        fontSize = 17.sp,
        lineHeight = 22.sp),

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

    headlineLarge = TextStyle(
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 36.09.sp,
        fontFamily = FontFamily(Font(R.font.sen))),

    headlineMedium = TextStyle(
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 18.05.sp,
        letterSpacing = -0.33.sp,
        fontFamily = FontFamily(Font(R.font.sen))),

    headlineSmall = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Thin,
        lineHeight = 26.sp,
        fontFamily = FontFamily(Font(R.font.sen))),

    titleLarge  = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 19.25.sp,
        letterSpacing = -0.33.sp,
        fontFamily = FontFamily(Font(R.font.sen))),

    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.sen)),
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 24.06.sp),

    titleSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.sen)),
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 24.sp),

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
