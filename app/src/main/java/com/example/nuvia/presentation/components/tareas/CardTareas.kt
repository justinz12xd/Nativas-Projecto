package com.example.nuvia.presentation.components.tareas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nuvia.Domain.model.Check
import com.example.nuvia.Domain.model.Tarea

@Composable
fun CardTareas(
    tareas: List<Tarea> = emptyList(),
    checks: List<Check> = emptyList(),
    onTareaToggle: (Int) -> Unit = {},
    onCheckToggle: (Int) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var mostrarChecks by remember { mutableStateOf(false) }
    
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.inverseSurface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            TareasHeader(
                mostrarChecks = mostrarChecks,
                onToggleView = { mostrarChecks = it }
            )
            
            Divider(
                color = MaterialTheme.colorScheme.background.copy(alpha = 0.2f),
                thickness = 1.dp
            )

            if (mostrarChecks) {
                ChecksList(
                    checks = checks,
                    onToggle = onCheckToggle
                )
            } else {
                TareasSemanaList(
                    tareas = tareas,
                    onToggle = onTareaToggle
                )
            }
        }
    }
}