package com.example.nuvia.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColors = darkColorScheme(
    primary = CalmBlue,
    secondary = GentleBlue,
    tertiary = SoftAqua,
    background = NightInk,
    surface = DeepSoftInk,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onSurface = FogWhite
)

private val LightColors = lightColorScheme(
    primary = CalmBlue,
    secondary = GentleBlue,
    tertiary = QuietBlue,
    background = FogWhite,
    surface = CloudWhite,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onSurface = SoftInk,

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
