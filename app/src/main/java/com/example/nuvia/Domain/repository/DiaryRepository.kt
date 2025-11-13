package com.example.nuvia.domain.repository

import com.example.nuvia.domain.model.DiaryEntry
import kotlinx.coroutines.flow.Flow

interface DiaryRepository {
    suspend fun saveEntry(content: String)
    fun getEntries(): Flow<List<DiaryEntry>>
}
