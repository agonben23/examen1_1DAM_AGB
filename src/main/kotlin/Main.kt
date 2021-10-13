fun main() {
    // Declaración de variables
    // Aqui tienes que definir las variables que se utilizan
    val miNombre="hibi"
    val edad: Byte
    val mes: Byte
    // Leo desde teclado la edad del alumno y el mes actual
    println("Introduzca la configuración del programa en este formato: <edadDelAlumno>,  <mesActual>")
    val entrada: String = readLine() ?: ""
    val listaEntrada = entrada.split(",")

    // Linea Inicial de programa
    println("*".repeat(80))
    println("PROGRAMA DE GENERACIÓN DE TABLAS: $miNombre")

    // Linea inicio cabecera
    println("_".repeat(80))

    if (listaEntrada.size != 2) //Compruebo el tamaño de la lista, si es != 2, finaliza el programa
    {
        println("La entrada no es correcta")
        println("_".repeat(80))
    }
    else { // Sino, leo edad y mes. Asigno -1 si hay error en la lectura.
        edad = try {listaEntrada[0].trim().toByte()} catch (e: Exception) {-1}
        mes = try {listaEntrada[1].trim().toByte()} catch (e: Exception) {-1}


        if ((edad <= 0 ) || (mes <= 0 )) // Si alguno es menor que -1, finaliza el programa
        {
            println("La entrada no es correcta")
            println("_".repeat(80))
        }
        else //Sino, continuo
        {
            //TODO("Aquí el código de la cabecera")
            println ("Edad: $edad. El alumno está dentro del rango ${rangoedad(edad)}")
            println ("Mes: $mes. El mes es ${mesParNopar(mes)}, corresponden las tablas siguientes: ${AdRango(edad,mes)}")
            //println ("La edad es $edad y el mes es $mes")

            // Linea final cabecera
            println("_".repeat(80))

            //Imprime las tablas en función de
            AdTabla(edad,mes)

        }

    }
    // Linea final de programa
    println("*".repeat(80))

}

fun rangoedad(edad: Byte): String {
     return when (edad) {
         in 6..8 -> "[6-8]"
         in 9..10 -> "[9-10]"
         in 11..12 -> "[11-12]"
         else -> ""
     }

}
fun creartabla(numTabla: Byte) { //Crea la tabla utilizando la tabla indicada para su edad y mes
    println("TABLA DEL $numTabla")
    println("*".repeat(11))
    for (i in 1..10) {
        val result = numTabla * i
        println("$numTabla X $i = $result")
    }
    println("")
}
fun mesParNopar(mes: Byte): String{ //Devuelve si el mes es par o no par
    if (mes % 2 == 0){
        return ("par")
    }else
        return ("impar")
}
fun AdTabla(edad: Byte,mes: Byte) { //Adjudica las tablas dependiendo de la edad
    when (edad) {
        in 6..8 -> "${e68(mes)}"
        in 9..10 -> "${e910(mes)}"
        in 11..12 -> "${e1112()}"
    }
}
fun e68(mes: Byte){ // Adjudica las tablas para edades entre 6 y 8 años
    if (mes % 2 == 0) {
        creartabla(2)
        creartabla(4)
    } else {
        creartabla(1)
        creartabla(3)
        creartabla(5)
    }
}
fun e910(mes: Byte){ // Adjudica las tablas para edades entre 9 y 10 años
    if (mes % 2 == 0) {
        creartabla(6)
        creartabla(8)
        creartabla(10)
    } else {
        creartabla(7)
        creartabla(9)
    }
}
fun e1112(){ // Adjudica las tablas para edades entre 11 y 12 años
        creartabla(11)
        creartabla(12)
        creartabla(13)
}
fun AdRango(edad: Byte,mes: Byte) : String{ //Adjudica el rango dependiendo de la edad
    return when (edad) {
        in 6..8 -> "${r68(mes)}"
        in 9..10 -> "${r910(mes)}"
        in 11..12 -> "${r1112()}"
        else -> ""
    }
}
fun r68(mes: Byte): String{ // Adjudica el rango para edades entre 6 y 8 años
    if (mes % 2 == 0) {
        return "{2,4}"
    } else {
        return "{1,3,5}"
    }
}
fun r910(mes: Byte): String{ // Adjudica el rango para edades entre 9 y 10 años
    if (mes % 2 == 0) {
        return "{6,8,10}"
    } else {
        return "{7,9}"
    }
}
fun r1112(): String{ // Adjudica el rango para edades entre 11 y 12 años
      return "{11,12,13}"
}