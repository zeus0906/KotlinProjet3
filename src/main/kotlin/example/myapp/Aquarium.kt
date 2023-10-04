package example.myapp

//class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {
open class Aquarium (open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {

    // Dimensions in cm

    /* var width: Int = 20
    var height: Int = 40
    var length: Int = 100 */

    init {
        println("aquarium initializing")
    }
   /* init {
        // 1 liter = 1000 cm^3
        println("Volume: ${width * length * height / 1000} liters")
    } */

    constructor(numberOfFish: Int) : this() {
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1
        // calculate the height needed
        height = (tank / (length * width)).toInt()
    }
    // property volume to return the volume
    // Changing volume to a var so that it can be set more than once
  /*  var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        } */
    open val shape = "rectangle"
    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open var water: Double = 0.0
        get() = volume * 0.9

    fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")

        // 1 liter = 1000 cm^3
      //  println("Volume: $volume liters")

        // 1 l = 1000 cm^3
        println("Volume: $volume liters Water: $water liters (${water / volume * 100.0}% full)")

    }
}