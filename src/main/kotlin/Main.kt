
fun main(args: Array<String>) {
    // Tache 3
    val isUnit = println("C'est une expression")
    println(isUnit)

    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)

    val message = "La temperature de l'eau est ${if (temperature > 50) "c'est chaud" else "OK"}."
    println(message)
}