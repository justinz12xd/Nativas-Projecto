package com.example.nuvia.domain.model

import java.time.LocalDate

data class Tarea(
    val id: Int,
    val titulo: String,
    val descripcion: String? = null,
    val fecha: LocalDate,
    val completada: Boolean = false,
    val prioridad: PrioridadTarea = PrioridadTarea.MEDIA
)

enum class PrioridadTarea {
    BAJA, MEDIA, ALTA
}