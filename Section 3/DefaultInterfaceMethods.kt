@file:Suppress("unused")

package classes

interface Stoppable : Drivable {
    fun stop() = println("I'm stopping")
}

class StoppableCar : Stoppable {
    override fun drive() {
        println("I'm driving")
    }
}