package com.example.nuvia.domain.repository

import com.example.nuvia.domain.model.FechaImportante

interface RepositorioCalendario {
    suspend fun getImportantDates(): List<FechaImportante>
    suspend fun addImportantDate(fecha: FechaImportante)
    suspend fun removeImportantDate(id: Int)
}