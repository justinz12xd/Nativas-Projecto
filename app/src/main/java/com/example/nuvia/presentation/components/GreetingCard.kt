package com.example.nuvia.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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

    val emoji = when {
        horaActual < 12 -> "☀️"
        horaActual < 18 -> "🌤️"
        else -> "🌙"
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.inverseSurface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top= 30.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Saludo principal
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = emoji,
                    fontSize = 28.sp
                )
                Column {
                    Text(
                        text = buenos,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.background.copy(alpha = 0.7f),
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        text = name,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.background,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }

            Divider(
                color = MaterialTheme.colorScheme.background.copy(alpha = 0.2f),
                thickness = 1.dp
            )

            Text(
                text = "¡Todas tus metas se pueden cumplir!",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.background.copy(alpha = 0.8f),
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = 20.sp
            )
        }
    }
}