package com.example.nuvia.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColors = darkColorScheme(
    primary = TealBlue,
    secondary = DarkBlue,
    background = VeryDarkBlue,
    surface = NightBlue,
    onPrimary = Color.White,
    onSurface = Color.White
)

private val LightColors = lightColorScheme(
    primary = MediumBlue,
    secondary = TealBlue,
    tertiary = DeepBlue,
    background = LightBlue,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onSurface = Color.Black
)

@Composable
fun NuviaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
