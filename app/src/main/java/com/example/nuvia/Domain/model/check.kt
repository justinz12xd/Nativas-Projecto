package com.example.nuvia.Domain.model

data class Check(
    val id: Int,
    val texto: String,
    val completado: Boolean = false,
    val fechaCreacion: Long = System.currentTimeMillis()
)