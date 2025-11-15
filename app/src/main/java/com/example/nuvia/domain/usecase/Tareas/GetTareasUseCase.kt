package com.example.nuvia.domain.usecase.Tareas

import com.example.nuvia.domain.model.Tarea
import com.example.nuvia.domain.repository.TareasRepository
import kotlinx.coroutines.flow.Flow

class GetTareasUseCase(
    private val repository: TareasRepository
) {
    operator fun invoke(): Flow<List<Tarea>> {
        return repository.getTareas()
    }
}

