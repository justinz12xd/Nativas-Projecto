package com.example.nuvia.domain.usecase.Tareas

import com.example.nuvia.domain.repository.TareasRepository

class DeleteCheckUseCase(
    private val repository: TareasRepository
) {
    suspend operator fun invoke(id: Int) {
        repository.deleteCheck(id)
    }
}

