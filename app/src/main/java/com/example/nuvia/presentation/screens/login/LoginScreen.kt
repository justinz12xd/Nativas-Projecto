package com.example.nuvia.presentation.screens.login

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onGoRegister: () -> Unit
) {
    var nombre by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var visible by remember { mutableStateOf(false) }
    
    val titleAlpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(durationMillis = 1000),
        label = "title"
    )
    val fraseAlpha by animateFloatAsState(
        targetValue =  if (visible) 1f else 0f,
        animationSpec = tween(durationMillis = 800),
        label= "frase"
    )
    
    val nombreAlpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(durationMillis = 800, delayMillis = 200),
        label = "nombre"
    )
    
    val passwordAlpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(durationMillis = 800, delayMillis = 400),
        label = "password"
    )
    
    val buttonAlpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(durationMillis = 800, delayMillis = 600),
        label = "button"
    )
    
    LaunchedEffect(Unit) {
        visible = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Título con animación
        Text(
            text = "Bienvenido a Nuvia",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.graphicsLayer(alpha = titleAlpha)
        )
        
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text= "El primer paso es empezar",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.graphicsLayer(alpha = fraseAlpha)
        )

        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer(alpha = nombreAlpha)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Password con animación
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer(alpha = passwordAlpha)
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Botón con animación
        Button(
            onClick = onLoginSuccess,
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer(alpha = buttonAlpha)
        ) {
            Text("Iniciar Sesión")
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Botón para ir a registro
        TextButton(
            onClick = onGoRegister,
            modifier = Modifier.graphicsLayer(alpha = buttonAlpha)
        ) {
            Text("¿No tienes cuenta? Regístrate")
        }
    }
}