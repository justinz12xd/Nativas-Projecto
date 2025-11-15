package com.example.nuvia.domain.usecase.Tareas

import com.example.nuvia.domain.repository.TareasRepository
import kotlinx.coroutines.flow.first

class ToggleTareaUseCase(
    private val repository: TareasRepository
) {
    suspend operator fun invoke(id: Int) {
        // Obtener la tarea actual
        val tareas = repository.getTareas().first()
        val tarea = tareas.find { it.id == id } ?: return
        
        // Toggle el estado de completada
        val tareaActualizada = tarea.copy(completada = !tarea.completada)
        
        // Actualizar en el repositorio
        repository.updateTarea(tareaActualizada)
    }
}

