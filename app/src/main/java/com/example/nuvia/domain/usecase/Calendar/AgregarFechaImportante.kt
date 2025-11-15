package com.example.nuvia.domain.usecase.Calendar

import com.example.nuvia.domain.repository.RepositorioCalendario
import com.example.nuvia.domain.model.FechaImportante

class AddImportantDate(private val repo: RepositorioCalendario) {
    suspend operator fun invoke(fecha: FechaImportante) = repo.addImportantDate(fecha)
}