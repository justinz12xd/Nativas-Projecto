package com.example.nuvia.presentation.screens.calendario

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import com.example.nuvia.domain.model.FechaImportante
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import java.time.YearMonth

@Composable
fun CalendarView(
    importantDates: List<FechaImportante>,
    onDayClick: (LocalDate) -> Unit,
    modifier: Any
) {
    val today = LocalDate.now()
    val currentMonth = YearMonth.now()
    val firstDayOfMonth = currentMonth.atDay(1)

    val daysInMonth = currentMonth.lengthOfMonth()
    val offset = firstDayOfMonth.dayOfWeek.value % 7

    val importantDatesList = importantDates.map { it.fecha }

    LazyVerticalGrid(
        columns = GridCells.Fixed(7),
        modifier = Modifier.padding(top= 120.dp)
    ) {
        // Espacios vacíos
        items(offset) {
            CalendarDayCellPlaceholder()
        }

        // Días reales
        items(daysInMonth) { index ->
            val dayNumber = index + 1
            val date = currentMonth.atDay(dayNumber)

            CalendarDayCell(
                date = date,
                important = importantDatesList.contains(date),
                onClick = onDayClick
            )
        }
    }
}
