// QuizData.kt
package com.pdm0126.taller1_00112233

import com.pdm0126.taller1_00382523.Pregunta


val listaPreguntas = listOf(
    Pregunta(
        id = 1,
        pregunta = "¿Cuál fue el factor técnico clave que permitió a Android ser adoptado por múltiples fabricantes?",
        opcion = listOf(
            "Su compatibilidad exclusiva con hardware Google",
            "Su arquitectura basada en Linux y código abierto",
            "Su integración obligatoria con servicios de Apple",
            "Su diseño enfocado solo en tablets"
        ),
        correcto = "Su arquitectura basada en Linux y código abierto",
        DatoCurioso = "El kernel de Linux permite que Android funcione en una enorme variedad de dispositivos con diferentes arquitecturas."
    ),
    Pregunta(
        id = 2,
        pregunta = "¿En qué año Google compró Android?",
        opcion = listOf(
            "2003",
            "2005",
            "2008",
            "2010"
        ),
        correcto = "2005",
        DatoCurioso = "La compra de Android por Google fue clave para competir contra Apple en el mercado móvil."
    ),
    Pregunta(
        id = 3,
        pregunta = "¿Cuál fue una estrategia clave de Google para competir contra iOS en los primeros años de Android?",
        opcion = listOf(
            "Cerrar el código fuente del sistema",
            "Licenciar Android gratuitamente a fabricantes",
            "Eliminar la personalización del sistema",
            "Restringir el uso a dispositivos Nexus"
        ),
        correcto = "Licenciar Android gratuitamente a fabricantes",
        DatoCurioso = "A diferencia de Apple, Google permitió que muchas empresas usaran Android gratis, lo que aceleró su expansión global."
    )
)