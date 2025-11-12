package com.example.nuvia.presentation.screens.register

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
fun RegisterScreen(
    onRegisterSuccess: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember  { mutableStateOf("")}

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
    
    val emailAlpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(durationMillis = 800, delayMillis = 200),
        label = "email"
    )
    
    val passwordAlpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(durationMillis = 800, delayMillis = 400),
        label = "password"
    )

    val passwordAlpha2 by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(durationMillis = 800, delayMillis = 400),
        label = "repeatPassword"
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
            text= "Registrate con confianza, es TÚ lugar",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.graphicsLayer(alpha = fraseAlpha)
        )

        Spacer(modifier = Modifier.height(16.dp))
        
        // Email con animación
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer(alpha = emailAlpha)
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
        
        Spacer(modifier = Modifier.height(16.dp))

        // Password repetida con animación
        OutlinedTextField(
            value = repeatPassword,
            onValueChange = { repeatPassword = it },
            label = { Text("Repetir Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer(alpha = passwordAlpha2)
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Botón con animación
        Button(
            onClick = onRegisterSuccess,
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer(alpha = buttonAlpha)
        ) {
            Text("Registrarse")
        }
    }
}