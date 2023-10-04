import java.util.*

fun feedTheFish(){
    val jour = randomJour()
    val repas = randomRepas()
    println("Aujourd'hui est $jour et je mange le $repas")
}

fun randomJour() : String{
    val semaine = arrayOf("Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche")
    return semaine[Random().nextInt(semaine.size)]
}

fun randomRepas() : String{
    val food = arrayOf("Tilapia", "Machoiron", "Carpe", "maquereau", "Bar", "Thon", "Saumon")
    return food[Random().nextInt(food.size)]
}
fun main(args : Array<String>){
    feedTheFish()
}