package example.myapp

import java.lang.Math.PI

open class Aquarium(length: Int = 100, width: Int = 20, height: Int = 40) {

    open var volume: Int
        get() = width * height * length / 1000  // 1000 cm^3 = 1 litre
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open val shape = "rectangle"
    open var water: Double = 0.0
        get() = volume * 0.9

    init {
        println("Initialisation de l'aquarium")
    }
    /*init {
        // 1 liter = 1000 cm^3
        println("Volume: ${width * length * height / 1000} litres")
    }*/

    // Dimensions en cm
    var length: Int = length
    var width: Int = width
    open var height: Int = height

    constructor(numberOfFish: Int) : this() {
        // 2,000 cm^3 par poisson + espace supplémentaire pour que l’eau ne se renverse pas
        val tank = numberOfFish * 2000 * 1.1

        // calculer la hauteur nécessaire
        height = (tank / (length * width)).toInt()
    }

    //Partie 4


    fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")

        // 1 litre = 1000 cm^3
        println("Volume: $volume litres d'eau: $water litres (${water / volume * 100.0}% full)")
    }
}

class TowerTank (override var height: Int, var diameter: Int): Aquarium(height = height, width = diameter, length = diameter) {
    override var volume: Int
        // l'aire de l'ellipse = π * r1 * r2
        get() = (width/2 * length/2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width/2 * length/2)).toInt()
        }

    override var water = volume * 0.8
    override val shape = "cylinder"
}