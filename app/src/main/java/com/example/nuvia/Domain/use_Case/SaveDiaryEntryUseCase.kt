package com.example.nuvia.domain.usecase

import com.example.nuvia.domain.repository.DiaryRepository

class SaveDiaryEntryUseCase(
    private val repository: DiaryRepository
) {
    suspend operator fun invoke(content: String) {
        repository.saveEntry(content)
    }
}

