package com.example.nuvia.presentation.components.tareas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.nuvia.Domain.model.Tarea
import java.time.format.DateTimeFormatter
import java.util.*


@Composable
fun TareaItem(
    tarea: Tarea,
    formatter: DateTimeFormatter,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Checkbox(
                checked = tarea.completada,
                onCheckedChange = { onToggle() }
            )
            
            TareaContent(
                tarea = tarea,
                formatter = formatter
            )
        }
    }
}

@Composable
private fun TareaContent(
    tarea: Tarea,
    formatter: DateTimeFormatter
) {
    Column() {
        Text(
            text = tarea.titulo,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = if (tarea.completada) FontWeight.Normal else FontWeight.Medium,
            color = if (tarea.completada) 
                MaterialTheme.colorScheme.background.copy(alpha = 0.6f)
            else 
                MaterialTheme.colorScheme.background
        )
        Text(
            text = tarea.fecha.format(formatter),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.background.copy(alpha = 0.5f)
        )
    }
}