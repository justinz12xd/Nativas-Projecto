package com.example.nuvia.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nuvia.data.datasource.RecuerdosLocalDatasource
import com.example.nuvia.data.repository.RecuerdosRepositoryImpl
import com.example.nuvia.domain.repository.RecuerdosRepository
import com.example.nuvia.presentation.screens.recuerdos.RecuerdosViewModel
import com.example.nuvia.domain.usecase.Recuerdos.*

class RecuerdosViewModelFactory: ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecuerdosViewModel::class.java)){
            val datasSource = RecuerdosLocalDatasource()
            val repository = RecuerdosRepositoryImpl(datasSource)
            //Se agregan tambien los casos de uso q hice enante
            val getRecuerdos = GetRecuerdosUseCase(repository)
            val addRecuerdo = AddRecuerdoUseCase(repository)
            val deleteRecuerdo = DeleteRecuerdoUseCase(repository)

            @Suppress("UNCHECKED_CAST")
            return RecuerdosViewModel(getRecuerdos, addRecuerdo, deleteRecuerdo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
