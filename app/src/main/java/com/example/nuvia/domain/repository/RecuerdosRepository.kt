package com.example.nuvia.domain.repository

import com.example.nuvia.domain.model.Recuerdo
import kotlinx.coroutines.flow.Flow

interface RecuerdosRepository {
    fun getRecuerdosRepository(): Flow<List<Recuerdo>>
    suspend  fun addRecuerdo(recuerdo: Recuerdo)
    suspend fun deleteRecuerdo(id: Int)
}