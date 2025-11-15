package com.example.nuvia.domain.usecase.Tareas

import com.example.nuvia.domain.repository.TareasRepository
import kotlinx.coroutines.flow.first

class ToggleCheckUseCase(
    private val repository: TareasRepository
) {
    suspend operator fun invoke(id: Int) {
        // Obtener el check actual
        val checks = repository.getChecks().first()
        val check = checks.find { it.id == id } ?: return
        
        // Toggle el estado de completado
        val checkActualizado = check.copy(completado = !check.completado)
        
        // Actualizar en el repositorio
        repository.updateCheck(checkActualizado)
    }
}

