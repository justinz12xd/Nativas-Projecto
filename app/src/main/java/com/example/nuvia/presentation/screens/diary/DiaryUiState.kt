package com.example.nuvia.presentation.screens.diary

import com.example.nuvia.domain.model.DiaryEntry

data class DiaryUiState(
    val content: String = "",
    val entries: List<DiaryEntry> = emptyList()
)
