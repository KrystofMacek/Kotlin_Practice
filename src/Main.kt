fun main() {

    // val water filter = labda funkce
    val waterFilter = {dirty :Int -> dirty / 2}
    // val water filter 2, (specification) function with Int input and Int output = labda funkce
    val waterFilter2:(Int) -> Int = {dirty -> dirty / 2}


    println(updateDirty(40, waterFilter2))
}

//Higher order function
// argument of type Int and argument Function that is specified to take in Int and return Int, return type is also Int
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

