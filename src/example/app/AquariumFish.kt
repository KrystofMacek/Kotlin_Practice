package example.app

//Interface providing property of color
interface FishColor {
    val color: String
}
// Singleton Color classes
object GoldColor: FishColor{
    override val color = "Gold"
}
object GreyColor: FishColor{
    override val color = "Grey"
}

// Fish action - Eating
interface FishAction {
    fun eat()
}
class PrintingFishAction(private val food: String): FishAction {
    override fun eat() {
        println("Eating $food")
    }
}

// implementation of interfaces, Color and Action are delegated to other classes ("by")

class Shark(fishColor: FishColor = GreyColor):
        FishColor by fishColor,
        FishAction by PrintingFishAction("smaller fish")

class Plecostomus(fishColor: FishColor = GoldColor):
        FishColor by fishColor,
        FishAction by PrintingFishAction("algae")

//Sealed class - can only be subclassed in this file
//  Safe to represent fixed number of types - can be useful for returning success or error from a network API.
sealed class Seal
    class SeaLion : Seal()
    class Walrus : Seal()

fun matchSeal(seal: Seal): String {
    return when(seal) {
        is Walrus -> "Walrus"
        is SeaLion -> "SeaLion"
    }
}



