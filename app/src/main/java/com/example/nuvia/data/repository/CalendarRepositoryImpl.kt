package com.example.nuvia.data.repository

import com.example.nuvia.domain.model.FechaImportante
import com.example.nuvia.domain.repository.RepositorioCalendario
import com.example.nuvia.data.datasource.CalendarLocalDataSource

class CalendarRepositoryImpl(
    private val localDataSource: CalendarLocalDataSource
) : RepositorioCalendario {

    override suspend fun getImportantDates(): List<FechaImportante> {
        return localDataSource.getImportantDates()
    }

    override suspend fun addImportantDate(fecha: FechaImportante) {
        localDataSource.insertImportantDate(fecha)
    }

    override suspend fun removeImportantDate(id: Int) {
        localDataSource.deleteImportantDate(id)
    }
}