package com.example.nuvia.presentation.screens.calendario

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.clip
import java.time.LocalDate

@Composable
fun CalendarDayCell(
    date: LocalDate,
    important: Boolean,
    onClick: (LocalDate) -> Unit
) {
    val isToday = date == LocalDate.now()
    Box(
        modifier = Modifier
            .size(40.dp)
            .padding(4.dp)
            .clip(CircleShape)
            .background(
                when {
                    important -> MaterialTheme.colorScheme.tertiary
                    isToday -> MaterialTheme.colorScheme.primary
                    else -> MaterialTheme.colorScheme.surface
                }
            )
            .clickable { onClick(date) },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = date.dayOfMonth.toString(),
            color = when {
                important -> MaterialTheme.colorScheme.onTertiary
                isToday -> MaterialTheme.colorScheme.onPrimary
                else -> MaterialTheme.colorScheme.onSurface
            },
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun CalendarDayCellPlaceholder() {
    Box(
        modifier = Modifier
            .size(40.dp)
            .padding(4.dp),
        contentAlignment = Alignment.Center
    ) {}
}
