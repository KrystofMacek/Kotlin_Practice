package example.app.anotations

import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.findAnnotation

annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

@ImAPlant class Plant {

    @get:OnGet
    val isGrowing:Boolean = true

    @set:OnSet
    var needsFood:Boolean = false

    fun trim(){}
    fun fertilize(){}
}

fun testAnnotations() {
    val plantObject = Plant::class
    for (a in plantObject.annotations) {
        println(a.annotationClass.simpleName)
    }

    val plantAnnotation = plantObject.findAnnotation<ImAPlant>()
    println(plantAnnotation)
}

// Labels - breaking outerLoop
fun labels() {
    outerLoop@ for (i in 1..100) {
        for(j in 1..4) {
            if(i>10) break@outerLoop
            println(j)
        }
        println("outer $i ")
    }
}

fun main() {
    testAnnotations()
    labels()
}