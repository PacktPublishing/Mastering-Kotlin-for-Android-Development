@file:Suppress("unused", "UNUSED_VARIABLE")

import java.util.*
import kotlin.collections.ArrayList

class Car : Any() {
    fun drive() {
        println("driving")
    }
}

fun noPrimitiveType() {
    val i: Int = 3 // compiles to Java primitive int
    val boxedInt: Int? = 19 // compiles to Java's reference Integer type
    val intList:List<Int> = ArrayList() //this will use Java's reference Integer as generic type
}

val immutableList: List<String> = ArrayList()
val mutableList: MutableList<String> = ArrayList()


fun lists() {
    //can't modify immutable list
    immutableList.add("Kotlin")
    mutableList.add("Kotlin")

    immutableList.toMutableList().add("Kotlin")
}


fun reflection() {
    val car = Car()
    val method = car.javaClass.getMethod("drive", null)
    method.invoke(car, null)
}
