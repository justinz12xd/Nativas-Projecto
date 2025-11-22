package com.example.nuvia.domain.model
import java.time.LocalDate


data class Recuerdo(
    val id_recuerdo:Int,
    val titulo: String,
    val descripcion: String,
    val fecha: LocalDate,
    val imagenUrl: String?= null //TENER EN CUENTA QUE LUEGO SERA CON BD
)