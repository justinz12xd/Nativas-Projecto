package com.example.nuvia.presentation.screens.diary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nuvia.data.datasource.DiaryLocalDataSource
import com.example.nuvia.data.repository.DiaryRepositoryImpl
import com.example.nuvia.domain.usecase.GetDiaryEntriesUseCase
import com.example.nuvia.domain.usecase.SaveDiaryEntryUseCase

class DiaryViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Data layer
        val local = DiaryLocalDataSource()
        val repository = DiaryRepositoryImpl(local)

        // Domain layer
        val save = SaveDiaryEntryUseCase(repository)
        val get = GetDiaryEntriesUseCase(repository)

        return DiaryViewModel(save, get) as T
    }
}
