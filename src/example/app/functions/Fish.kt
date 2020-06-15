package example.app.functions

data class Fish(var name: String) {
}

fun fishExamples() {
    val fish = Fish("dory")
//    with(fish.name) {
//        println(this.capitalize())
//    }
    myWith(fish.name) {
        println(capitalize())
    }

    /*
    * run() and apply() are similar, but run() returns the result of applying the function,
    * and apply() returns the object after applying the function.
    * */
    fish.run {
        name
    }
    val fish2 = Fish(name = "splashy").apply {
        name = "sharky"
    }
    println(fish2.name)

    // The let() function is similar to apply(), but it returns a copy of the object with the changes.
    // This can be useful for chaining manipulations together.
    println("*****")
    println(fish.let { it.name.capitalize() }
            .let { it + "fish" }
            .let { it.length }
            .let { it + 34 })
    println(fish)
}

// Higher Order Functions
// block will be an extension function of String
fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

fun main() {
    fishExamples()
}