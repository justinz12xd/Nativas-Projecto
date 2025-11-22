// app/src/main/java/com/example/nuvia/presentation/screens/recuerdos/RecuerdosViewModel.kt
package com.example.nuvia.presentation.screens.recuerdos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nuvia.domain.model.Recuerdo
import com.example.nuvia.domain.usecase.Recuerdos.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class RecuerdosViewModel(
    private val getRecuerdosUseCase: GetRecuerdosUseCase,
    private val addRecuerdoUseCase: AddRecuerdoUseCase,
    private val deleteRecuerdoUseCase: DeleteRecuerdoUseCase
) : ViewModel() {

    private val _recuerdos = MutableStateFlow<List<Recuerdo>>(emptyList())
    val recuerdos: StateFlow<List<Recuerdo>> = _recuerdos.asStateFlow()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    private val _showDialog = MutableStateFlow(false)
    val showDialog: StateFlow<Boolean> = _showDialog.asStateFlow()

    init {
        viewModelScope.launch {
            // This is now safely called inside a coroutine.
            getRecuerdosUseCase().collect { recuerdoList ->
                _recuerdos.value = recuerdoList
            }
        }
    }

    fun openDialog() {
        _showDialog.value = true
    }

    fun closeDialog() {
        _showDialog.value = false
    }

    fun addRecuerdo(recuerdo: Recuerdo) {
        viewModelScope.launch {
            addRecuerdoUseCase(recuerdo)
            closeDialog()
        }
    }

    fun deleteRecuerdo(id: Int) {
        viewModelScope.launch {
            deleteRecuerdoUseCase(id)
        }
    }
}