package com.example.nuvia.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalTime

@Composable
fun CardSaludo(name: String) {
    val horaActual = LocalTime.now().hour
    val buenos = when {
        horaActual < 12 -> "Buenos días"
        horaActual < 18 -> "Buenas tardes"
        else -> "Buenas noches"
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(10.dp)
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Text(
                text = "$buenos $name",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
