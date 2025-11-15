package com.example.nuvia.domain.usecase.Tareas

import com.example.nuvia.domain.model.Check
import com.example.nuvia.domain.repository.TareasRepository
import kotlinx.coroutines.flow.Flow

class GetChecksUseCase(
    private val repository: TareasRepository
) {
    operator fun invoke(): Flow<List<Check>> {
        return repository.getChecks()
    }
}

