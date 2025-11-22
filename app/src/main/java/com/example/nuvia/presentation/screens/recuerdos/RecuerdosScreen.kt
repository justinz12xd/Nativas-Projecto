// app/src/main/java/com/example/nuvia/presentation/screens/recuerdos/RecuerdosScreen.kt
package com.example.nuvia.presentation.screens.recuerdos

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nuvia.presentation.viewmodels.RecuerdosViewModelFactory
import androidx.navigation.NavController
import com.example.nuvia.presentation.components.FondoConImagen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecuerdosScreen(
    navController: NavController,
    viewModel: RecuerdosViewModel = viewModel(factory = RecuerdosViewModelFactory())
) {
    val recuerdos by viewModel.recuerdos.collectAsState()
    val showDialog by viewModel.showDialog.collectAsState()

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
                title = { Text("Recuerdos Importantes") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.openDialog() },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Agregar recuerdo")
            }
        }
    ) { paddingValues ->
        FondoConImagen(
            overlayAlpha = 0.3f
        ) {
            if (recuerdos.isEmpty()) {
                EmptyRecuerdosView(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(recuerdos.sortedByDescending { it.fecha }) { recuerdo ->
                        RecuerdoCard(
                            recuerdo = recuerdo,
                            onDelete = { viewModel.deleteRecuerdo(recuerdo.id_recuerdo) }
                        )
                    }
                }
            }
        }

        if (showDialog) {
            AddRecuerdoDialog(
                onDismiss = { viewModel.closeDialog() },
                onSave = { titulo, descripcion, fecha ->
                    viewModel.addRecuerdo(
                        com.example.nuvia.domain.model.Recuerdo(
                            id_recuerdo = (0..999999).random(),
                            titulo = titulo,
                            descripcion = descripcion,
                            fecha = fecha
                        )
                    )
                }
            )
        }
    }
}

@Composable
fun EmptyRecuerdosView(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.PhotoLibrary,
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f)
            )
            Text(
                text = "No hay recuerdos guardados",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = "Presiona el botón + para agregar tu primer recuerdo",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
            )
        }
    }
}