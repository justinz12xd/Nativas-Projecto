package com.example.nuvia.presentation.screens.diary

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nuvia.domain.usecase.GetDiaryEntriesUseCase
import com.example.nuvia.domain.usecase.SaveDiaryEntryUseCase
import kotlinx.coroutines.launch

class DiaryViewModel(
    private val saveDiaryEntry: SaveDiaryEntryUseCase,
    private val getDiaryEntries: GetDiaryEntriesUseCase
) : ViewModel() {

    var uiState by mutableStateOf(DiaryUiState())
        private set

    init {
        viewModelScope.launch {
            getDiaryEntries().collect { entries ->
                uiState = uiState.copy(entries = entries)
            }
        }
    }

    fun onContentChange(value: String) {
        uiState = uiState.copy(content = value)
    }

    fun saveEntry() {
        if (uiState.content.isBlank()) return

        viewModelScope.launch {
            saveDiaryEntry(uiState.content.trim())
            uiState = uiState.copy(content = "")
        }
    }
}
