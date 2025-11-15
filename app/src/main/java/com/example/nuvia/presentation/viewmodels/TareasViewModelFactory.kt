package com.example.nuvia.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nuvia.data.datasource.TareasLocalDataSource
import com.example.nuvia.data.repository.TareasRepositoryImpl
import com.example.nuvia.domain.usecase.Tareas.*

class TareasViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TareasViewModel::class.java)) {
            // Capa de datos
            val dataSource = TareasLocalDataSource()
            val repository = TareasRepositoryImpl(dataSource)
            
            // Casos de uso
            val getTareasUseCase = GetTareasUseCase(repository)
            val getChecksUseCase = GetChecksUseCase(repository)
            val toggleTareaUseCase = ToggleTareaUseCase(repository)
            val toggleCheckUseCase = ToggleCheckUseCase(repository)
            val addTareaUseCase = AddTareaUseCase(repository)
            val addCheckUseCase = AddCheckUseCase(repository)
            val deleteTareaUseCase = DeleteTareaUseCase(repository)
            val deleteCheckUseCase = DeleteCheckUseCase(repository)
            
            @Suppress("UNCHECKED_CAST")
            return TareasViewModel(
                getTareasUseCase = getTareasUseCase,
                getChecksUseCase = getChecksUseCase,
                toggleTareaUseCase = toggleTareaUseCase,
                toggleCheckUseCase = toggleCheckUseCase,
                addTareaUseCase = addTareaUseCase,
                addCheckUseCase = addCheckUseCase,
                deleteTareaUseCase = deleteTareaUseCase,
                deleteCheckUseCase = deleteCheckUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

