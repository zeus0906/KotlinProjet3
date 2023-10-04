package example.myapp

class Plecostomus(fishColor: FishColor = GoldColor): FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor {
   // override val color = "gold"
  /*  override fun eat() {
        println("eat algae")
    } */
}