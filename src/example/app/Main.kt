package example.app

import example.app.decor.Decoration

fun buildAquarium() {
    val niceAquarium = Aquarium()
    niceAquarium.printSize()

    val aquarios = Aquarium(width = 33)
    aquarios.printSize()

    val aquios = Aquarium(width = 24, height = 77)
    aquios.printSize()

    val aqo = Aquarium(57,33,809)
    aqo.printSize()

    val aquioso = Aquarium(numOfFish = 93)
    aquioso.printSize()

    val tankAquarium = TowerTank(50, 25)
    tankAquarium.printSize()
}

fun makeFish() {
    val shark = Shark()
    shark.eat()
    val pleco = Plecostomus()
    pleco.eat()

    println("Shark color: ${shark.color}, Plecostomus color: ${pleco.color}")
}

fun makeDecoration() {
    val decoration1 = Decoration("granite")
    println(decoration1)

    val decoration2 = Decoration("slate")
    println(decoration2)

    val decoration3 = Decoration("slate")
    println(decoration3)

    //equality Test if we comparing use == / if we want to check if variable refers to same object use ===
    println (decoration1 == decoration2)
    println (decoration3 == decoration2)
    println (decoration3 === decoration2)

    //Destructuring
    val (rocks, wood, diver) = decoration2
    println("--$rocks $wood $diver")

}

//enum class
enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

fun printEnums() {
    println(Direction.EAST.name)
    println(Direction.EAST.ordinal)
    println(Direction.EAST.degrees)
}



fun main() {
    //buildAquarium()
    //makeFish()
    //makeDecoration()
    //printEnums()


}