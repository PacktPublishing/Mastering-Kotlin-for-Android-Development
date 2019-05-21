@file:Suppress("unused")

package classes

abstract class BaseCar {

    abstract val isDrivable: Boolean

    abstract fun drive()
}

class RoadCar : BaseCar() {
    override val isDrivable: Boolean
        get() = true

    override fun drive() {
        println("I'm driving")
    }
}