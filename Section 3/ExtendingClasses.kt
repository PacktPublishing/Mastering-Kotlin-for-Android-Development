@file:Suppress("unused", "RemoveEmptyClassBody")

package classes

open class Car {
    fun drive() {
        println("I'm driving")
    }

    open fun accelerate() {
        println("I can't drive faster")
    }
}

open class SportsCar : Car() {

//    override fun drive() {
//
//    }

    final override fun accelerate() {
        println("I'm accelerating")
    }
}

class SuperSportsCar : SportsCar() {
//    override fun accelerate() {
//
//    }
}

