package com.example.nuvia.presentation.components.tareas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.nuvia.Domain.model.Check

@Composable
fun CheckItem(
    check: Check,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Checkbox(
            checked = check.completado,
            onCheckedChange = { onToggle() }
        )
        
        Text(
            text = check.texto,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = if (check.completado) FontWeight.Normal else FontWeight.Medium,
            color = if (check.completado) 
                MaterialTheme.colorScheme.background.copy(alpha = 0.6f)
            else 
                MaterialTheme.colorScheme.background,
            modifier = Modifier.weight(1f)
        )
    }
}