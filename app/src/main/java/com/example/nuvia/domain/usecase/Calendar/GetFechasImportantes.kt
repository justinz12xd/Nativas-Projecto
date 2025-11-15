package com.example.nuvia.domain.usecase.Calendar

import com.example.nuvia.domain.repository.RepositorioCalendario


class GetFechasImportantes (private val repo: RepositorioCalendario) {
    suspend operator fun invoke() = repo.getImportantDates()
}

