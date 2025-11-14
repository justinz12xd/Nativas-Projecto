package com.example.nuvia.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.nuvia.domain.model.Check
import com.example.nuvia.domain.model.PrioridadTarea
import com.example.nuvia.domain.model.Tarea
import java.time.LocalDate

class TareasViewModel : ViewModel() {

    private val _tareas = mutableStateOf<List<Tarea>>(emptyList())
    val tareas: List<Tarea> by _tareas

    private val _checks = mutableStateOf<List<Check>>(emptyList())
    val checks: List<Check> by _checks

    private val _isLoading = mutableStateOf(false)
    val isLoading: Boolean by _isLoading

    init {
        loadDatosEjemplo()
    }

    private fun loadDatosEjemplo() {
        _tareas.value = listOf(
            Tarea(
                id = 1,
                titulo = "Trabajo Autonomo de aplicaciones Nativas",
                descripcion = "Revisar correos pendientes",
                fecha = LocalDate.now().plusDays(1),
                completada = false,
                prioridad = PrioridadTarea.MEDIA
            ),
            Tarea(
                id = 2,
                titulo = "Exposicion de Arquitectura del Software",
                descripcion = "Reunión semanal de seguimiento",
                fecha = LocalDate.now().plusDays(2),
                completada = true,
                prioridad = PrioridadTarea.ALTA
            ),
            Tarea(
                id = 3,
                titulo = "Tarea #4 de Aplicaciones Web",
                descripcion = "Reporte mensual de actividades",
                fecha = LocalDate.now().plusDays(3),
                completada = false,
                prioridad = PrioridadTarea.ALTA
            ),
            Tarea(
                id = 4,
                titulo = "Subir Repositorio Personal",
                descripcion = "Preparar slides para la reunión",
                fecha = LocalDate.now().plusDays(4),
                completada = false,
                prioridad = PrioridadTarea.BAJA
            )
        )

        _checks.value = listOf(
            Check(id = 1, texto = "Meditar", completado = false),
            Check(id = 2, texto = "Hacer Tareas", completado = true),
            Check(id = 3, texto = "Hablar con mis amigos", completado = false),
            Check(id = 4, texto = "Leer mi libro", completado = false),
            Check(id = 5, texto = "Hacer ejercicio", completado = false)
        )
    }

    fun toggleTarea(id: Int) {
        _tareas.value = _tareas.value.map { tarea ->
            if (tarea.id == id) {
                tarea.copy(completada = !tarea.completada)
            } else {
                tarea
            }
        }
    }

    fun toggleCheck(id: Int) {
        _checks.value = _checks.value.map { check ->
            if (check.id == id) {
                check.copy(completado = !check.completado)
            } else {
                check
            }
        }
    }

    fun agregarTarea(tarea: Tarea) {
        _tareas.value = _tareas.value + tarea
    }

    fun agregarCheck(check: Check) {
        val nuevoId = (_checks.value.maxOfOrNull { it.id } ?: 0) + 1
        _checks.value = _checks.value + check.copy(id = nuevoId)
    }

    fun eliminarTarea(id: Int) {
        _tareas.value = _tareas.value.filter { it.id != id }
    }

    fun eliminarCheck(id: Int) {
        _checks.value = _checks.value.filter { it.id != id }
    }
}