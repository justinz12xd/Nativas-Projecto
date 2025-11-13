package com.example.nuvia.presentation.components.tareas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nuvia.Domain.model.Tarea
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun TareasSemanaList(
    tareas: List<Tarea>,
    onToggle: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val formatter = DateTimeFormatter.ofPattern("EEE, d MMM")
    
    val tareasSemana = tareas.filter { tarea ->
        val hoy = LocalDate.now()
        val semanaSiguiente = hoy.plusDays(7)
        tarea.fecha.isAfter(hoy.minusDays(1)) && 
        tarea.fecha.isBefore(semanaSiguiente)
    }
    
    if (tareasSemana.isEmpty()) {
        EmptyTareasMessage(
            message = "No hay tareas para esta semana",
            modifier = modifier
        )
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.heightIn(max = 300.dp)
        ) {
            items(tareasSemana) { tarea ->
                TareaItem(
                    tarea = tarea,
                    formatter = formatter,
                    onToggle = { onToggle(tarea.id) }
                )
            }
        }
    }
}

@Composable
private fun EmptyTareasMessage(
    message: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = message,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
        modifier = modifier.padding(vertical = 16.dp)
    )
}