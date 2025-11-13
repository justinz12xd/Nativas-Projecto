package com.example.nuvia.data.repository

import com.example.nuvia.data.datasource.DiaryLocalDataSource
import com.example.nuvia.domain.model.DiaryEntry
import com.example.nuvia.domain.repository.DiaryRepository
import kotlinx.coroutines.flow.Flow

class DiaryRepositoryImpl(
    private val local: DiaryLocalDataSource
) : DiaryRepository {

    override suspend fun saveEntry(content: String) {
        local.saveEntry(content)
    }

    override fun getEntries(): Flow<List<DiaryEntry>> {
        return local.getEntries()
    }
}
