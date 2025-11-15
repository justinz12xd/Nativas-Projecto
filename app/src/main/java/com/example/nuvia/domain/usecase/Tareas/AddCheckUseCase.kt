package com.example.nuvia.domain.usecase.Tareas

import com.example.nuvia.domain.model.Check
import com.example.nuvia.domain.repository.TareasRepository

class AddCheckUseCase(
    private val repository: TareasRepository
) {
    suspend operator fun invoke(check: Check) {
        repository.addCheck(check)
    }
}

