package example.app

object Constants {
    const val CONST = "Constants must be declared inside singleton (object)"
}
class ConstClass {
    companion object {
        const val CONST = "If you want const inside normal class. Have to use companion object"
    }
}
