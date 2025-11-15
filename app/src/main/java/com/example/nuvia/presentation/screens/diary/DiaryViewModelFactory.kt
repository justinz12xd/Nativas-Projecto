package com.example.nuvia.presentation.screens.diary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nuvia.data.datasource.DiaryLocalDataSource
import com.example.nuvia.data.repository.DiaryRepositoryImpl
import com.example.nuvia.domain.usecase.Diary.GetDiaryEntriesUseCase
import com.example.nuvia.domain.usecase.SaveDiaryEntryUseCase

class DiaryViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DiaryViewModel::class.java)) {
            // Capa de datos
            val local = DiaryLocalDataSource()
            val repository = DiaryRepositoryImpl(local)
            
            // Casos de uso
            val save = SaveDiaryEntryUseCase(repository)
            val get = GetDiaryEntriesUseCase(repository)

            @Suppress("UNCHECKED_CAST")
            return DiaryViewModel(save, get) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
