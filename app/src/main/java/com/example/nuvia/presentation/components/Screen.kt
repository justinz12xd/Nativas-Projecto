package com.example.nuvia.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen(
        route = "com/example/nuvia/presentation/components/home",
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
        icon = Icons.Default.Book
    )
    object Calendario : Screen(
        route = "com/example/nuvia/presentation/components/calendario",
        title = "Calendario",
        icon = Icons.Default.DateRange
    )
    object Recuerdos: Screen(
        route = "recuerdos",
        title = "Recuerdos",
        icon = Icons.Default.PhotoLibrary
    )
    object Configuracion : Screen(
        route = "configuracion",
        title = "Configuración",
        icon = Icons.Default.Settings
    )


}

