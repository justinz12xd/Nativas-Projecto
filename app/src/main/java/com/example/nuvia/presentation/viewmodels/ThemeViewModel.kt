package com.example.nuvia.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ThemeViewModel : ViewModel() {
    private var _isDarkTheme by mutableStateOf(false)
    val isDarkTheme: Boolean
        get() = _isDarkTheme

    fun toggleTheme() {
        _isDarkTheme = !_isDarkTheme
    }

    fun updateTheme(enabled: Boolean) {
        _isDarkTheme = enabled
    }
}

