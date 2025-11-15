package com.example.nuvia.presentation.screens.calendario

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nuvia.domain.usecase.Calendar.GetFechasImportantes
import com.example.nuvia.domain.usecase.Calendar.AddImportantDate
import com.example.nuvia.data.repository.CalendarRepositoryImpl
import com.example.nuvia.data.datasource.CalendarLocalDataSource
import com.example.nuvia.presentation.viewmodels.CalendarViewModel

class CalendarViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CalendarViewModel::class.java)) {
            // Capa de datos
            val dataSource = CalendarLocalDataSource()
            val repository = CalendarRepositoryImpl(dataSource)
            
            // Casos de uso
            val getFechasImportantes = GetFechasImportantes(repository)
            val addImportantDate = AddImportantDate(repository)
            
            @Suppress("UNCHECKED_CAST")
            return CalendarViewModel(getFechasImportantes, addImportantDate) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}