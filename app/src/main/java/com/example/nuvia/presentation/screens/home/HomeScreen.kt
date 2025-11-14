package com.example.nuvia.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.nuvia.presentation.components.CardSaludo
import com.example.nuvia.presentation.components.Screen
import com.example.nuvia.presentation.components.tareas.CardTareas
import com.example.nuvia.presentation.theme.CalmBlue
import com.example.nuvia.presentation.viewmodels.TareasViewModel
import com.example.nuvia.presentation.components.FondoConImagen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val viewModel: TareasViewModel = viewModel()
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Refugio") },
                actions = {
                    IconButton(onClick = {
                        navController.navigate(Screen.Profile.route)
                    }) {
                        Icon(Icons.Default.Person, contentDescription = "Perfil")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = CalmBlue,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        FondoConImagen(
            overlayAlpha = 0.3f
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 80.dp,
                        bottom = paddingValues.calculateBottomPadding()
                    ),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CardSaludo(name = "Justin")
                CardTareas(
                    tareas = viewModel.tareas,
                    checks = viewModel.checks,
                    onTareaToggle = { id -> viewModel.toggleTarea(id) },
                    onCheckToggle = { id -> viewModel.toggleCheck(id) }
                )
            }
        }
    }
}