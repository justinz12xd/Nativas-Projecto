package com.example.nuvia.presentation.screens.calendario

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import com.example.nuvia.domain.model.FechaImportante
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.nuvia.presentation.components.calendario.CalendarDayCell
import com.example.nuvia.presentation.components.calendario.CalendarDayCellPlaceholder
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale
import kotlin.math.ceil

@Composable
fun CalendarView(
    importantDates: List<FechaImportante>,
    onDayClick: (LocalDate) -> Unit,
    modifier: Modifier = Modifier
) {
    val today = LocalDate.now()
    val currentMonth = YearMonth.now()
    val firstDayOfMonth = currentMonth.atDay(1)

    val daysInMonth = currentMonth.lengthOfMonth()
    val offset = firstDayOfMonth.dayOfWeek.value % 7

    val importantDatesList = importantDates.map { it.fecha }
    
    // Obtener nombre del mes y año
    val monthName = currentMonth.month.getDisplayName(TextStyle.FULL, Locale("es", "ES"))
        .replaceFirstChar { it.uppercase() }
    val year = currentMonth.year
    
    // Calcular el número de semanas necesarias
    val totalCells = offset + daysInMonth
    val rows = ceil(totalCells / 7.0).toInt()

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Header con mes y año
            Text(
                text = "$monthName $year",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )
            
            HorizontalDivider(
                color = MaterialTheme.colorScheme.outlineVariant,
                thickness = 1.dp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            // Headers de días de la semana
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                val daysOfWeek = listOf("D", "L", "M", "M", "J", "V", "S")
                daysOfWeek.forEach { day ->
                    Text(
                        text = day,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center
                    )
                }
            }
            
            // Grid del calendario usando Column y Row
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                var cellIndex = 0
                
                // Crear filas
                repeat(rows) { rowIndex ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        // 7 columnas por fila
                        repeat(7) { colIndex ->
                            if (cellIndex < offset) {
                                // Espacios vacíos antes del primer día
                                Box(modifier = Modifier.weight(1f)) {
                                    CalendarDayCellPlaceholder()
                                }
                            } else {
                                val dayNumber = cellIndex - offset + 1
                                if (dayNumber <= daysInMonth) {
                                    // Día válido
                                    val date = currentMonth.atDay(dayNumber)
                                    Box(modifier = Modifier.weight(1f)) {
                                        CalendarDayCell(
                                            date = date,
                                            important = importantDatesList.contains(date),
                                            onClick = onDayClick
                                        )
                                    }
                                } else {
                                    // Espacios vacíos después del último día
                                    Box(modifier = Modifier.weight(1f)) {
                                        CalendarDayCellPlaceholder()
                                    }
                                }
                            }
                            cellIndex++
                        }
                    }
                }
            }
        }
    }
}
