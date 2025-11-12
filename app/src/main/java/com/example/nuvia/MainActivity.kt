package com.example.nuvia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.nuvia.presentation.navigation.NavGraph
import com.example.nuvia.presentation.theme.NuviaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NuviaTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}