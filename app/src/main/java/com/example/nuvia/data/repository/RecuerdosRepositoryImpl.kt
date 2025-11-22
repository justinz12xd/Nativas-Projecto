package com.example.nuvia.data.repository

import com.example.nuvia.domain.model.Recuerdo
import com.example.nuvia.data.datasource.RecuerdosLocalDatasource
import com.example.nuvia.domain.repository.RecuerdosRepository
import kotlinx.coroutines.flow.Flow

class RecuerdosRepositoryImpl(
    private val localDataSource: RecuerdosLocalDatasource)
    : RecuerdosRepository {
    override fun getRecuerdosRepository(): Flow<List<Recuerdo>> {
        return localDataSource.getRecuerdos()
    }
    override suspend fun addRecuerdo(recuerdo: Recuerdo){
        localDataSource.addRecuerdo(recuerdo)
    }
    override suspend fun deleteRecuerdo(id: Int){
        localDataSource.deleteRecuerdo(id)
    }
}