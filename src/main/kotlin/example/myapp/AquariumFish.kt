package example.myapp


abstract class AquariumFish : FishAction{
    abstract val color : String
    override fun eat() {
        println("yum")
    }
}


class Shark : AquariumFish(), FishAction {
    override val color = "grey"
    override fun eat(){
        println("chasser et manger le poisson")
    }
}

class Plecostomus : AquariumFish(), FishAction {
    override val color = "gold"
    override fun eat(){
        println("manger les Algues")
    }
}

interface FishAction{
    fun eat()
}


