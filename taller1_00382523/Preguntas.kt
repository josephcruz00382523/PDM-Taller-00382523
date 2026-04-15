package com.pdm0126.taller1_00382523


data class Pregunta(
    val id: Int,
    val pregunta: String,
    val opcion: List<String>,
    val correcto: String,
    val DatoCurioso: String
)