package com.example.nuvia.data.datasource

import com.example.nuvia.domain.model.DiaryEntry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DiaryLocalDataSource {

    private val entries = MutableStateFlow<List<DiaryEntry>>(emptyList())

    private var nextId = 1

    fun saveEntry(content: String) {
        val newEntry = DiaryEntry(
            id = nextId++,
            content = content,
            date = System.currentTimeMillis()
        )
        entries.value = listOf(newEntry) + entries.value
    }

    fun getEntries() = entries.asStateFlow()
}
