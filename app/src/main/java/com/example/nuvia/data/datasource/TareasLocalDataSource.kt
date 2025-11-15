package com.example.nuvia.data.datasource

import com.example.nuvia.domain.model.Tarea
import com.example.nuvia.domain.model.Check
import com.example.nuvia.domain.model.PrioridadTarea
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class TareasLocalDataSource {
    
    // Datos hardcodeados en el DataSource (capa de datos)
    private val _tareas = MutableStateFlow(
        listOf(
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
    )
    
    private val _checks = MutableStateFlow(
        listOf(
            Check(id = 1, texto = "Meditar", completado = false),
            Check(id = 2, texto = "Hacer Tareas", completado = true),
            Check(id = 3, texto = "Hablar con mis amigos", completado = false),
            Check(id = 4, texto = "Leer mi libro", completado = false),
            Check(id = 5, texto = "Hacer ejercicio", completado = false)
        )
    )
    
    fun getTareas(): Flow<List<Tarea>> = _tareas
    
    fun getChecks(): Flow<List<Check>> = _checks
    
    suspend fun updateTarea(tarea: Tarea) {
        _tareas.value = _tareas.value.map { 
            if (it.id == tarea.id) tarea else it 
        }
    }
    
    suspend fun updateCheck(check: Check) {
        _checks.value = _checks.value.map { 
            if (it.id == check.id) check else it 
        }
    }
    
    suspend fun addTarea(tarea: Tarea) {
        _tareas.value = _tareas.value + tarea
    }
    
    suspend fun addCheck(check: Check) {
        _checks.value = _checks.value + check
    }
    
    suspend fun deleteTarea(id: Int) {
        _tareas.value = _tareas.value.filter { it.id != id }
    }
    
    suspend fun deleteCheck(id: Int) {
        _checks.value = _checks.value.filter { it.id != id }
    }
}

