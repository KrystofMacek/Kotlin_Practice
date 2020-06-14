package example.app

open class Aquarium(open var width: Int = 20, open var height: Int = 40, open var length: Int = 100) {

    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open val shape = "rectangle"
    open var water: Double = 0.0
        get() = volume * 0.9

    init {
        println("aquarium initializing")
    }
    constructor(numOfFish: Int): this() {
        val tank = numOfFish * 2000 * 1.1
        height = (tank/(length * width)).toInt()
    }
    fun printSize() {
        println("Width = $width, Height = $height Length = $length")

        println("aquarium volume: $volume l")
    }
}