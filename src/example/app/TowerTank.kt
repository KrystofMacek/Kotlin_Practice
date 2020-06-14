package example.app

import kotlin.math.PI

class TowerTank(override var height:Int, var diameter:Int):
        Aquarium(height = height, width = diameter, length = diameter) {
    override var volume: Int
        get() = (width/2 * length/2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width/2 * length/2)).toInt()
        }

    override var water = volume * 8.0
    override var shape = "cylinder"

}