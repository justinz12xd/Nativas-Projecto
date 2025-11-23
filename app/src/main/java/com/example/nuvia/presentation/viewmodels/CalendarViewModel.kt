package com.example.nuvia.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.example.nuvia.domain.model.FechaImportante
import com.example.nuvia.domain.usecase.Calendar.GetFechasImportantes
import com.example.nuvia.domain.usecase.Calendar.AddImportantDate
import java.time.LocalDate

class CalendarViewModel(
    private val getImportantDates: GetFechasImportantes,
    private val addImportantDate: AddImportantDate
) : ViewModel() {

    private val _importantDates = MutableStateFlow<List<FechaImportante>>(emptyList())
    val importantDates: StateFlow<List<FechaImportante>> = _importantDates.asStateFlow()

    private val _showDialog = MutableStateFlow(false)
    val showDialog: StateFlow<Boolean> = _showDialog.asStateFlow()

    private val _selectedDate = MutableStateFlow<LocalDate?>(null)
    val selectedDate: StateFlow<LocalDate?> = _selectedDate.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _importantDates.value = getImportantDates()
        }
    }

    fun onDaySelected(date: LocalDate) {
        _selectedDate.value = date
        _showDialog.value = true
    }

    fun closeDialog() {
        _showDialog.value = false
        _selectedDate.value = null
    }

    fun saveImportantDate(date: LocalDate, title: String, description: String = "") {
        if (title.isBlank()) return
        
        viewModelScope.launch {
            addImportantDate(
                FechaImportante(
                    id_fecha = (0..999999).random(),
                    fecha = date,
                    titulo = title,
                    descripcion = description.ifBlank { null }
                )
            )
            loadData()
            closeDialog()
        }
    }
}
