package com.example.nuvia.presentation.navigation

sealed class Routes(val route: String) {
    object Splash : Routes("splash")
    object Login : Routes("login")
    object Register : Routes("register")
    object Main : Routes("main")
    object Profile : Routes("profile")
    object Home : Routes("home")
    object Diary : Routes("diary")
}