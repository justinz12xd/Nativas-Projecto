package com.example.nuvia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.nuvia.presentation.navigation.NavGraph
import com.example.nuvia.presentation.theme.NuviaTheme
import com.example.nuvia.presentation.viewmodels.ThemeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val themeViewModel: ThemeViewModel = viewModel()
            
            NuviaTheme(darkTheme = themeViewModel.isDarkTheme) {
                val navController = rememberNavController()
                NavGraph(
                    navController = navController,
                    themeViewModel = themeViewModel
                )
            }
        }
    }
}