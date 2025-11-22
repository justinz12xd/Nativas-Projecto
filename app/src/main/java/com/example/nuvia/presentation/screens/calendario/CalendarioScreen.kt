package com.example.nuvia.presentation.screens.calendario

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.nuvia.presentation.viewmodels.CalendarViewModel
import com.example.nuvia.presentation.components.FondoConImagen
import com.example.nuvia.presentation.components.Screen
import com.example.nuvia.presentation.components.calendario.AddDateDialog
import com.example.nuvia.presentation.components.calendario.ImportantDatesCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen(
    viewModel: CalendarViewModel = viewModel(factory = CalendarViewModelFactory()),
    navController: NavHostController
) {
    val importantDates by viewModel.importantDates.collectAsState()
    val showDialog by viewModel.showDialog.collectAsState()
    val selectedDate by viewModel.selectedDate.collectAsState()

    Scaffold(
        containerColor = Color.Transparent,
        contentColor = Color.Transparent,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                title = { Text("Calendario") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {navController.navigate(Screen.Recuerdos.route)},
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            ) {
                Icon(
                    imageVector = Icons.Default.PhotoLibrary,
                    contentDescription = "Ver recuerdos"
                )
            }
        }
    ) { paddingValues ->
        FondoConImagen(
            overlayAlpha = 0.3f
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // Calendario con Card
                item {
                    CalendarView(
                        importantDates = importantDates,
                        onDayClick = { date ->
                            viewModel.onDaySelected(date)
                        }
                    )
                }
                
                // Card con fechas importantes guardadas
                item {
                    ImportantDatesCard(
                        dates = importantDates
                    )
                }
                
                // Espaciado al final
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
        
        // Diálogo para agregar fecha importante
        if (showDialog && selectedDate != null) {
            AddDateDialog(
                date = selectedDate!!,
                onDismiss = { viewModel.closeDialog() },
                onSave = { title, description ->
                    viewModel.saveImportantDate(selectedDate!!, title, description)
                }
            )
        }
    }
}