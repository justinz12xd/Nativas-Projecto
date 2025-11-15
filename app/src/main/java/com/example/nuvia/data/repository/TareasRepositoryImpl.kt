package com.example.nuvia.data.repository

import com.example.nuvia.data.datasource.TareasLocalDataSource
import com.example.nuvia.domain.model.Tarea
import com.example.nuvia.domain.model.Check
import com.example.nuvia.domain.repository.TareasRepository
import kotlinx.coroutines.flow.Flow

class TareasRepositoryImpl(
    private val localDataSource: TareasLocalDataSource
) : TareasRepository {
    
    override fun getTareas(): Flow<List<Tarea>> {
        return localDataSource.getTareas()
    }
    
    override fun getChecks(): Flow<List<Check>> {
        return localDataSource.getChecks()
    }
    
    override suspend fun updateTarea(tarea: Tarea) {
        localDataSource.updateTarea(tarea)
    }
    
    override suspend fun updateCheck(check: Check) {
        localDataSource.updateCheck(check)
    }
    
    override suspend fun addTarea(tarea: Tarea) {
        localDataSource.addTarea(tarea)
    }
    
    override suspend fun addCheck(check: Check) {
        localDataSource.addCheck(check)
    }
    
    override suspend fun deleteTarea(id: Int) {
        localDataSource.deleteTarea(id)
    }
    
    override suspend fun deleteCheck(id: Int) {
        localDataSource.deleteCheck(id)
    }
}

