import java.util.*
// Tache 4
fun fishFood (day : String) : String {
    return when (day) {
        "Lundi" -> "flakes"
        "Mardi" -> "pellets"
        "Mercredi" -> "redworms"
        "Jeudi" -> "granules"
        "Vendredi" -> "mosquitoes"
        "Samedi" -> "lettuce"
        "Dimanche" -> "plankton"
        else -> "nothing"
    }
}
fun feedTheFish(){
    val jour = randomJour()
    val repas = fishFood(jour)
    println("Aujourd'hui est $jour et je mange le $repas")
    println("L'eau Change : ${shouldChangeWater(jour)}")
}

fun randomJour() : String{
    val semaine = arrayOf("Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche")
    return semaine[Random().nextInt(semaine.size)]
}

/*fun randomRepas() : String{
    val food = arrayOf("Tilapia", "Machoiron", "Carpe", "maquereau", "Bar", "Thon", "Saumon")
    return food[Random().nextInt(food.size)]
}*/


////////////////////////////////////////////////////////////
// Tache 5

/*fun swim(speed: String = "fast"){
    println("swimming $speed")
}*/

fun shouldChangeWater (day : String, temperature : Int = 22, dirty: Int = 20): Boolean{
    return when {
        isTooHot(temperature)  -> true
        isDirty(dirty)  -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

////////////////////////////////////////////////////////////

// Tache 6
val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

fun main(args: Array<String>) {
    // Tache 3
    /*val isUnit = println("C'est une expression")
    println(isUnit)

    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)

    val message = "La temperature de l'eau est ${if (temperature > 50) "c'est chaud" else "OK"}."
    println(message)
    feedTheFish()*/

    println(decorations.filter{it[0] == 'p'})


}