package com.example.nuvia.presentation.components.tareas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TareasHeader(
    mostrarChecks: Boolean,
    onToggleView: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = if (mostrarChecks) "Mis Checks" else "Tareas de la Semana",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.background
        )
        
        TareasSwitch(
            mostrarChecks = mostrarChecks,
            onToggleView = onToggleView
        )
    }
}

@Composable
private fun TareasSwitch(
    mostrarChecks: Boolean,
    onToggleView: (Boolean) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Switch(
            checked = mostrarChecks,
            onCheckedChange = onToggleView
        )

    }
}