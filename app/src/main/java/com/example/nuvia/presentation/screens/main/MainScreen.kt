package com.example.nuvia.presentation.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nuvia.presentation.components.BottomNavBar
import com.example.nuvia.presentation.components.Screen
import com.example.nuvia.presentation.screens.home.HomeScreen
import com.example.nuvia.presentation.screens.profile.ProfileScreen
import com.example.nuvia.presentation.screens.diary.DiaryScreen
import com.example.nuvia.presentation.screens.calendario.CalendarScreen
import com.example.nuvia.presentation.screens.recuerdos.RecuerdosScreen
import com.example.nuvia.presentation.screens.configuracion.ConfiguracionScreen
import com.example.nuvia.presentation.viewmodels.ThemeViewModel

@Composable
fun MainScreen(
    themeViewModel: ThemeViewModel,
    onLogout: () -> Unit = {}
) {
    // NavController anidado para las pantallas con navbar
    val nestedNavController = rememberNavController()
    
    Scaffold(
        bottomBar = {
            BottomNavBar(navController = nestedNavController)
        }
    ) { paddingValues ->
        // NavHost anidado para las pantallas que tienen navbar
        NavHost(
            navController = nestedNavController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController = nestedNavController)
            }
            
            composable(Screen.Profile.route) {
                ProfileScreen(navController = nestedNavController)
            }
            
            composable(Screen.Diary.route) {
                DiaryScreen(navController = nestedNavController)
            }
            composable(Screen.Calendario.route) {
                CalendarScreen(navController = nestedNavController)
            }
            composable(Screen.Recuerdos.route) {
                RecuerdosScreen(navController = nestedNavController)
            }
            composable(Screen.Configuracion.route) {
                ConfiguracionScreen(
                    navController = nestedNavController,
                    themeViewModel = themeViewModel,
                    onLogout = onLogout
                )
            }
        }
    }
}
