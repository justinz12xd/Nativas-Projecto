package com.example.nuvia.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen(
        route = "home",
        title = "Inicio",
        icon = Icons.Default.Home
    )
    
    object Profile : Screen(
        route = "profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )
    
    object Diary : Screen(
        route = "diary",
        title = "Diarios",
        icon = Icons.Default.DateRange
    )

}

