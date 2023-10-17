<<<<<<< HEAD
import java.util.*

fun fishFood (day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}


fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)

    println ("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")

}


fun main(args: Array<String>) {
    feedTheFish()
    swim()   // uses default speed
    swim("slow")   // positional argument
    swim(speed="turtle-like")   // named parameter
    println( decorations.filter {it[0] == 'p'})
////////////////////////////////////////////////////////////
    val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    // eager, creates a new list
    val eager = decorations.filter { it [0] == 'p' }
    println("eager: $eager")

    // lazy, will wait until asked to evaluate
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")

    // force evaluation of the lazy list
    val newList = filtered.toList()
    println("new list: $newList")

    /////////////////////////////// creating a list of all lists and transform to one list
    val mysports = listOf("basketball", "fishing", "running")
    val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
    val mylist = listOf(mysports, myplayers, mycities)     // list of lists
    println("-----")
    println("Flat: ${mylist.flatten()}")


}
fun randomDay() : String {
    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}
fun swim(speed: String = "fast") {
    println("swimming $speed")
}

fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else  -> false
    }

    /*  return when {
        temperature > 30 -> true
        dirty > 30 -> true
        day == "Sunday" ->  true
        else -> false
    } */
}

val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")


fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"



=======
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
>>>>>>> ec3e29f3a58a63bb4af402a73d4316a22483076e
