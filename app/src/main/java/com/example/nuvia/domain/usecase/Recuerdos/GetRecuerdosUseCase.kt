package com.example.nuvia.domain.usecase.Recuerdos

import com.example.nuvia.domain.repository.RecuerdosRepository
import com.example.nuvia.domain.model.Recuerdo

class GetRecuerdosUseCase(private val repository: RecuerdosRepository) {
    suspend operator fun invoke() = repository.getRecuerdosRepository()
}