package com.example.nuvia.domain.usecase

import com.example.nuvia.domain.repository.DiaryRepository

class GetDiaryEntriesUseCase(
    private val repository: DiaryRepository
) {
    operator fun invoke() = repository.getEntries()
}
