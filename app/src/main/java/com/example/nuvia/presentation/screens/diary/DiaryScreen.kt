package com.example.nuvia.presentation.screens.diary

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun DiaryScreen(viewModel: DiaryViewModel = viewModel(factory = DiaryViewModelFactory())) {
    val state = viewModel.uiState

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = state.content,
            onValueChange = viewModel::onContentChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Escribe tus pensamientos...") },
            maxLines = 4
        )

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = viewModel::saveEntry,
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Guardar entrada")
        }

        Spacer(Modifier.height(24.dp))

        LazyColumn {
            items(state.entries) { entry ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {
                    Column(Modifier.padding(12.dp)) {
                        Text(entry.content)
                        Text(
                            text = formatDate(entry.date),
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }
            }
        }
    }
}

private fun formatDate(date: Long): String {
    val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
    return sdf.format(Date(date))
}
