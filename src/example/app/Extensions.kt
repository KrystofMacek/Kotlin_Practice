package example.app

class Extensions {
}

class AquariumPlant(val color: String, private val size: Int)

//extension function
fun AquariumPlant.isRed() = color == "red"
//extension property
val AquariumPlant.isGreen: Boolean
    get() = color == "green"


//The ?. operator can be paired with apply to check for null before executing code.
fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}
val plant: AquariumPlant? = null
