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

@Composable
fun Resultados(score: Int, totalQuestions: Int, onRestart: () -> Unit) {

    val message = when (score) {
        3 -> "¡Excelente! Eres un experto en Android "
        2 -> "¡Bien hecho! Conoces bastante de Android "
        1 -> "Puedes mejorar. ¡Sigue estudiando! "
        else -> "¡No te rindas! Intenta de nuevo "
    }

    val scoreColor = when (score) {
        3 -> Color(0xFF4CAF50)
        2 -> Color(0xFF8BC34A)
        1 -> Color(0xFFFFA726)
        else -> Color(0xFFEF5350)
    }

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
            text = "Resultado Final",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = TextoBlanco
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Obtuviste $score de $totalQuestions",
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            color = TextoBlanco
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = message,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            color = scoreColor,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(48.dp))
        Button(
            onClick = onRestart,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = VerdePrimario,
                contentColor = Color.Black
            )
        ) {
            Text(text = "Reiniciar Quiz", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}