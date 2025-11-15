package com.example.nuvia.domain.usecase.Tareas

import com.example.nuvia.domain.model.Tarea
import com.example.nuvia.domain.repository.TareasRepository

class AddTareaUseCase(
    private val repository: TareasRepository
) {
    suspend operator fun invoke(tarea: Tarea) {
        repository.addTarea(tarea)
    }
}

