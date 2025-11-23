package com.example.nuvia.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nuvia.domain.model.Check
import com.example.nuvia.domain.model.Tarea
import com.example.nuvia.domain.usecase.Tareas.*
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TareasViewModel(
    private val getTareasUseCase: GetTareasUseCase,
    private val getChecksUseCase: GetChecksUseCase,
    private val toggleTareaUseCase: ToggleTareaUseCase,
    private val toggleCheckUseCase: ToggleCheckUseCase,
    private val addTareaUseCase: AddTareaUseCase,
    private val addCheckUseCase: AddCheckUseCase,
    private val deleteTareaUseCase: DeleteTareaUseCase,
    private val deleteCheckUseCase: DeleteCheckUseCase
) : ViewModel() {

    val tareas: StateFlow<List<Tarea>> = getTareasUseCase()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    val checks: StateFlow<List<Check>> = getChecksUseCase()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun toggleTarea(id: Int) {
        viewModelScope.launch {
            toggleTareaUseCase(id)
        }
    }

    fun toggleCheck(id: Int) {
        viewModelScope.launch {
            toggleCheckUseCase(id)
        }
    }

    fun agregarTarea(tarea: Tarea) {
        viewModelScope.launch {
            addTareaUseCase(tarea)
        }
    }

    fun agregarCheck(check: Check) {
        viewModelScope.launch {
            addCheckUseCase(check)
        }
    }

    fun eliminarTarea(id: Int) {
        viewModelScope.launch {
            deleteTareaUseCase(id)
        }
    }

    fun eliminarCheck(id: Int) {
        viewModelScope.launch {
            deleteCheckUseCase(id)
        }
    }
}