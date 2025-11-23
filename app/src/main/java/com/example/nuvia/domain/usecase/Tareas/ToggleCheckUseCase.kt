package com.example.nuvia.domain.usecase.Tareas

import com.example.nuvia.domain.repository.TareasRepository
import kotlinx.coroutines.flow.first

class ToggleCheckUseCase(
    private val repository: TareasRepository
) {
    suspend operator fun invoke(id: Int) {
        val checks = repository.getChecks().first()
        val check = checks.find { it.id == id } ?: return
        val checkActualizado = check.copy(completado = !check.completado)
        
        repository.updateCheck(checkActualizado)
    }
}

