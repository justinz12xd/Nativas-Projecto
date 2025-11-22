package com.example.nuvia.domain.usecase.Recuerdos
import com.example.nuvia.domain.repository.RecuerdosRepository
import com.example.nuvia.domain.model.Recuerdo

class DeleteRecuerdoUseCase (private val repository: RecuerdosRepository) {
    suspend operator fun invoke(id_recuerdo: Int) = repository.deleteRecuerdo(id_recuerdo)
}