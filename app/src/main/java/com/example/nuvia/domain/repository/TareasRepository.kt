package com.example.nuvia.domain.repository

import com.example.nuvia.domain.model.Tarea
import com.example.nuvia.domain.model.Check
import kotlinx.coroutines.flow.Flow

interface TareasRepository {
    fun getTareas(): Flow<List<Tarea>>
    fun getChecks(): Flow<List<Check>>
    suspend fun updateTarea(tarea: Tarea)
    suspend fun updateCheck(check: Check)
    suspend fun addTarea(tarea: Tarea)
    suspend fun addCheck(check: Check)
    suspend fun deleteTarea(id: Int)
    suspend fun deleteCheck(id: Int)
}

