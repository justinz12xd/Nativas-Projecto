package com.example.nuvia.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColors = darkColorScheme(
    // Colores principales
    primary = BrightSky,
    onPrimary = NightInk,
    primaryContainer = DeepAqua,
    onPrimaryContainer = BrightWhite,
    
    // Colores secundarios
    secondary = VividBlue,
    onSecondary = NightInk,
    secondaryContainer = DuskInk,
    onSecondaryContainer = BrightWhite,
    
    // Colores terciarios
    tertiary = SoftTeal,
    onTertiary = NightInk,
    tertiaryContainer = ShadowInk,
    onTertiaryContainer = BrightWhite,
    
    // Fondos y superficies
    background = NightInk,
    onBackground = BrightWhite,
    surface = MidnightInk,
    onSurface = BrightWhite,
    surfaceVariant = DuskInk,
    onSurfaceVariant = SoftWhite,
    
    // Estados de error
    error = SoftError,
    onError = NightInk,
    errorContainer = DarkErrorContainer,
    onErrorContainer = SoftError,
    
    // Bordes y divisores
    outline = ShadowInk,
    outlineVariant = DuskInk,
    
    // Contenedor inverso para mejor contraste
    inverseSurface = SoftWhite,
    inverseOnSurface = NightInk,
    inversePrimary = CalmBlue
)

private val LightColors = lightColorScheme(
    // Colores principales
    primary = CalmBlue,
    onPrimary = Color.White,
    primaryContainer = BabySky,
    onPrimaryContainer = DeepSoftInk,
    
    // Colores secundarios
    secondary = GentleBlue,
    onSecondary = Color.White,
    secondaryContainer = PastelSky,
    onSecondaryContainer = DeepSoftInk,
    
    // Colores terciarios
    tertiary = SoftTeal,
    onTertiary = Color.White,
    tertiaryContainer = MistWhite,
    onTertiaryContainer = DeepSoftInk,
    
    // Fondos y superficies
    background = FogWhite,
    onBackground = DeepSoftInk,
    surface = PureWhite,
    onSurface = DeepSoftInk,
    surfaceVariant = CloudWhite,
    onSurfaceVariant = SoftInk,
    
    // Estados de error
    error = DarkError,
    onError = Color.White,
    errorContainer = ErrorContainer,
    onErrorContainer = DarkError,
    
    // Bordes y divisores
    outline = QuietBlue.copy(alpha = 0.3f),
    outlineVariant = MistWhite,
    
    // Contenedor inverso para mejor contraste
    inverseSurface = SoftInk,
    inverseOnSurface = PureWhite,
    inversePrimary = BrightSky
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
