package com.example.nuvia.domain.usecase.Recuerdos
import com.example.nuvia.domain.model.Recuerdo
import com.example.nuvia.domain.repository.RecuerdosRepository

class AddRecuerdoUseCase(private val repository: RecuerdosRepository) {
    suspend operator fun invoke(recuerdo: Recuerdo) = repository.addRecuerdo(recuerdo)



}