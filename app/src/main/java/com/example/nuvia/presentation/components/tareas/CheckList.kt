package com.example.nuvia.presentation.components.tareas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nuvia.domain.model.Check

@Composable
fun ChecksList(
    checks: List<Check>,
    onToggle: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    if (checks.isEmpty()) {
        EmptyChecksMessage(modifier = modifier)
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.heightIn(max = 300.dp)
        ) {
            items(
                items = checks,
                key = { it.id }
            ) { check ->
                CheckItem(
                    check = check,
                    onToggle = { onToggle(check.id) }
                )
            }
        }
    }
}

@Composable
private fun EmptyChecksMessage(
    modifier: Modifier = Modifier
) {
    Text(
        text = "No hay checks agregados",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
        modifier = modifier.padding(vertical = 16.dp)
    )
}