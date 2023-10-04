package example.myapp


/*abstract class AquariumFish : FishAction{
    abstract val color : String
    override fun eat() {
        println("yum")
    }
}*/

interface FishAction{
    fun eat()
}

interface FishColor {
    val color: String
}

object GoldColor : FishColor {
    override val color = "gold"
}

class Shark : FishAction,FishColor {
    override val color = "grey"
    override fun eat(){
        println("chasser et manger le poisson")
    }
}

// Version 1 de Plecostomus pour la tache 6
/*class Plecostomus : FishAction,FishColor by GoldColor {
    override fun eat(){
        println("manger les Algues")
    }
}*/

// Version 2 de Plecostomus pour la tache 7
class Plecostomus (fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("manger les algues"),
    FishColor by fishColor

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}






