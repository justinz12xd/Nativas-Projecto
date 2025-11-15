package com.example.nuvia.domain.model

import java.time.LocalDate

data class FechaImportante (
    val id_fecha: Int,
    val fecha: LocalDate,
    val titulo: String,
    val descripcion: String? = null
)