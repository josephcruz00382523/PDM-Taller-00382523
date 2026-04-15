// MainActivity.kt
package com.pdm0126.taller1_00382523

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.pdm0126.taller1_00112233.listaPreguntas
import com.pdm0126.taller1_00112233.ui.*

enum class Screen { Inicio, Pregunta, Resultado }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidPediaApp()
        }
    }
}

@Composable
fun AndroidPediaApp() {
    var currentScreen by remember { mutableStateOf(Screen.Inicio) }
    var currentIndex by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }

    val pantalla = currentScreen
    val indice = currentIndex
    val puntaje = score

    when (pantalla) {
        Screen.Inicio -> {
            Inicio(
                onStartQuiz = { currentScreen = Screen.Pregunta }
            )
        }

        Screen.Pregunta -> {
            Preguntas(
                pregunta = listaPreguntas[indice],
                questionIndex = indice,
                totalQuestions = listaPreguntas.size,
                score = puntaje,
                onAnswerSelected = { selected ->
                    if (selected == listaPreguntas[indice].correcto) {
                        score++
                    }
                },
                onNext = {
                    if (indice < listaPreguntas.size - 1) {
                        currentIndex++
                    } else {
                        currentScreen = Screen.Resultado
                    }
                }
            )
        }

        Screen.Resultado -> {
            Resultados(
                score = puntaje,
                totalQuestions = listaPreguntas.size,
                onRestart = {
                    currentIndex = 0
                    score = 0
                    currentScreen = Screen.Inicio
                }
            )
        }
    }
}