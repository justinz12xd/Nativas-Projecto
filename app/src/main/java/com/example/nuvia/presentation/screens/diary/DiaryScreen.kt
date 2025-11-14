package com.example.nuvia.presentation.screens.diary

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import java.text.SimpleDateFormat
import java.util.*
import com.example.nuvia.presentation.components.FondoConImagen
import com.example.nuvia.presentation.theme.CalmBlue
import com.example.nuvia.domain.model.DiaryEntry

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiaryScreen(
    navController: NavController,
    viewModel: DiaryViewModel = viewModel(factory = DiaryViewModelFactory())
) {
    val state = viewModel.uiState

    Scaffold(
        containerColor = Color.Transparent,
        contentColor = Color.Transparent,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = CalmBlue,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                title = { Text("Diario") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { paddingValues ->
        FondoConImagen(
            overlayAlpha = 0.3f
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                TextField(
                    value = state.content,
                    onValueChange = viewModel::onContentChange,
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("¿Qué tal te fue hoy?") },
                    maxLines = 4
                )

                Spacer(Modifier.height(12.dp))

                Button(
                    onClick = viewModel::saveEntry,
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Guardar entrada")
                }

                Spacer(Modifier.height(24.dp))

                LazyColumn {
                    items(state.entries) { entry ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 6.dp)
                        ) {
                            Column(Modifier.padding(12.dp)) {
                                Text(entry.content)
                                Text(
                                    text = formatDate(entry.date),
                                    style = MaterialTheme.typography.labelSmall
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun formatDate(date: Long): String {
    val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
    return sdf.format(Date(date))
}
