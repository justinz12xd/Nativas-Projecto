package com.example.nuvia.data.datasource

import com.example.nuvia.domain.model.Recuerdo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class RecuerdosLocalDatasource {

    private val _recuerdos = MutableStateFlow(
        listOf(
            Recuerdo(
                id_recuerdo = 1,
                titulo = "Mi graduación",
                descripcion = "Un día muy especial donde culminé mis estudios universitarios. Fue un momento de gran alegría compartido con mi familia.",
                fecha = LocalDate.of(2023, 6, 15)
            ),
            Recuerdo(
                id_recuerdo = 2,
                titulo = "Viaje a la playa",
                descripcion = "Unas vacaciones increíbles en la costa. El atardecer del primer día fue inolvidable.",
                fecha = LocalDate.of(2023, 8, 20)
            ),
            Recuerdo(
                id_recuerdo = 3,
                titulo = "Primer día de trabajo",
                descripcion = "El inicio de una nueva etapa profesional llena de desafíos y aprendizajes.",
                fecha = LocalDate.of(2024, 1, 10)
            )
        )
    )
    fun getRecuerdos(): Flow<List<Recuerdo>> = _recuerdos

    suspend fun addRecuerdo(recuerdo: Recuerdo){
        _recuerdos.value = _recuerdos.value + recuerdo
    }

    suspend fun deleteRecuerdo(id_recuerdo: Int){
        _recuerdos.value = _recuerdos.value.filter{it.id_recuerdo != id_recuerdo}

    }
}