package com.example.food.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(
    primaryContainer = ButtonColor,
    secondary = DarkTextColor,
    onSecondary = LightTextColor,
    secondaryContainer = RoundedGrayTextField,
    tertiary = PlaceholderText,
    background = Background,
    onBackground = DarkBackground
)

private val LightColorPalette = lightColorScheme(
    primaryContainer = ButtonColor,
    secondary = DarkTextColor,
    onSecondary = LightTextColor,
    secondaryContainer = RoundedGrayTextField,
    tertiary = PlaceholderText,
    background = Background,
    onBackground = DarkBackground,


    /* Other default colors to override
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun FoodTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = FoodTypography,
        content = content
    )
}