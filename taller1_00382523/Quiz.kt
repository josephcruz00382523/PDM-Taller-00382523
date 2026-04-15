package com.pdm0126.taller1_00112233.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pdm0126.taller1_00382523.Pregunta

@Composable
fun Preguntas(
    pregunta: Pregunta,
    questionIndex: Int,
    totalQuestions: Int,
    score: Int,
    onAnswerSelected: (String) -> Unit,
    onNext: () -> Unit
) {
    var selectedAnswer by remember(questionIndex) { mutableStateOf<String?>(null) }
    val answered = selectedAnswer != null

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoOscuro)
            .padding(16.dp)
            .windowInsetsPadding(WindowInsets.statusBars),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Pregunta ${questionIndex + 1} de $totalQuestions",
                color = TextoGris
            )
            Text(
                text = "Puntaje: $score / $totalQuestions",
                color = VerdeClaro,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = TarjetaOscura)
        ) {
            Text(
                text = pregunta.pregunta,
                modifier = Modifier.padding(16.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = TextoBlanco
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        pregunta.opcion.forEach { opcion ->
            val buttonColor = when {
                !answered -> Color(0xFF2A2A3E)
                opcion == pregunta.correcto -> Color(0xFF2E7D32)
                opcion == selectedAnswer -> Color(0xFFC62828)
                else -> Color(0xFF3A3A4E)
            }
            val borderColor = when {
                !answered -> VerdePrimario
                opcion == pregunta.correcto -> Color(0xFF4CAF50)
                opcion == selectedAnswer -> Color(0xFFEF5350)
                else -> Color(0xFF555566)
            }

            Button(
                onClick = {
                    if (!answered) {
                        selectedAnswer = opcion
                        onAnswerSelected(opcion)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                enabled = !answered,
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor,
                    disabledContainerColor = buttonColor
                ),
                border = androidx.compose.foundation.BorderStroke(1.dp, borderColor)
            ) {
                Text(text = opcion, color = TextoBlanco)
            }
        }

        if (answered) {
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1B3A1F))
            ) {
                Text(
                    text = " ${pregunta.DatoCurioso}",
                    modifier = Modifier.padding(12.dp),
                    fontSize = 14.sp,
                    color = VerdeClaro
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onNext,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = VerdePrimario,
                    contentColor = Color.Black
                )
            ) {
                val label = if (questionIndex == totalQuestions - 1) "Ver Resultado" else "Siguiente"
                Text(text = label, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}