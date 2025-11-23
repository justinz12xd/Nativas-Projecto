package com.example.nuvia.data.datasource

import com.example.nuvia.domain.model.FechaImportante
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class CalendarLocalDataSource {

    private val data = mutableListOf<FechaImportante>()

    suspend fun getImportantDates(): List<FechaImportante> = data

    suspend fun insertImportantDate(fecha: FechaImportante) {
        data.add(fecha)
    }

    suspend fun deleteImportantDate(id: Int) {
        data.removeIf { it.id_fecha == id }
    }
}

