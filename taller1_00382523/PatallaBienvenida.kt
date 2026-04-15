package com.pdm0126.taller1_00112233.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val FondoOscuro = Color(0xFF1A1A2E)
val VerdePrimario = Color(0xFF4CAF50)
val VerdeClaro = Color(0xFFA5D6A7)
val TextoBlanco = Color(0xFFE0E0E0)
val TextoGris = Color(0xFF9E9E9E)
val TarjetaOscura = Color(0xFF2A2A3E)

@Composable
fun Inicio(onStartQuiz: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoOscuro)
            .padding(32.dp)
            .windowInsetsPadding(WindowInsets.statusBars),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = " AndroidPedia",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = VerdePrimario
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "¿Cuánto sabes de Android?",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            color = TextoGris
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Joseph Rodrigo Cruz Blanco", fontSize = 16.sp, color = TextoBlanco)
        Text(text = "Carnet: 00382523", fontSize = 16.sp, color = TextoBlanco)
        Spacer(modifier = Modifier.height(48.dp))
        Button(
            onClick = onStartQuiz,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = VerdePrimario,
                contentColor = Color.Black
            )
        ) {
            Text(text = "Comenzar Quiz", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}