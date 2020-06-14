package example.app.generics

// Any? = can be null
// Any = cant be null
// WaterSupply = must be type / subtype of WaterSuply
// Generic out type
class Aquarium<out T: WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        //check() Throws exception / IllegalState, with message
        //check(!waterSupply.needsProcessing) { "water supply needs processing first" }
        if(waterSupply.needsProcessing) {
            cleaner.clean(waterSupply)
        }
        println("adding water from $waterSupply")
    }

    // generic function - reified allows using "is" check on the generic type
    // reified can only be used on inline fun

}
inline fun<reified R: WaterSupply> Aquarium<*>.hasWaterSupplyOf() = waterSupply is R
//generic extension function of WaterSupply
inline fun<reified T: WaterSupply> WaterSupply.isTypeOf() = this is T

// Generic in type
interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}
class TapWaterCleaner: Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

fun<T: WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${!aquarium.waterSupply.needsProcessing}")
}

fun genericExample() {
    val cleaner = TapWaterCleaner()
    val aquarium = Aquarium(TapWater())
    //aquarium.addWater(cleaner)
    isWaterClean(aquarium)
    println(aquarium.hasWaterSupplyOf<TapWater>())
    println(aquarium.waterSupply.isTypeOf<LakeWater>())

}

fun main() {
    genericExample()
}

/* SUMMARY NOTES
Create generic classes to make code more flexible.
Add generic constraints to limit the types used with generics.
Use in and out types with generics to provide better type checking to restrict types being passed into or returned from classes.
Create generic functions and methods to work with generic types. For example:
    fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>) { ... }
Use generic extension functions to add non-core functionality to a class.
Reified types are sometimes necessary because of type erasure. Reified types, unlike generic types, persist to runtime.
Use the check() function to verify your code is running as expected. For example:
    check(!waterSupply.needsProcessing) { "water supply needs processing first" }
**/