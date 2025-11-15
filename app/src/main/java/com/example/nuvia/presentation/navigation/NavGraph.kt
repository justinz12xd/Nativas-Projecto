package com.example.nuvia.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nuvia.presentation.screens.login.LoginScreen
import com.example.nuvia.presentation.screens.main.MainScreen
import com.example.nuvia.presentation.screens.open_screen.OpenScreen
import com.example.nuvia.presentation.screens.register.RegisterScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.Splash.route
    ) {
        composable(Routes.Splash.route) {
            OpenScreen(navController = navController)
        }
        composable(Routes.Login.route){
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Routes.Main.route){
                        popUpTo(Routes.Login.route) { inclusive = true }
                        launchSingleTop = true
                    }
                },
                onGoRegister = {navController.navigate(Routes.Register.route)}
            )
        }
        composable(Routes.Register.route){
            RegisterScreen(
                onRegisterSuccess = {
                    navController.navigate(Routes.Main.route){
                        popUpTo(Routes.Register.route) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }
        composable(Routes.Main.route){
            MainScreen()
        }
    }
}