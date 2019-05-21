package kotlinbasics.kotlin

import kotlinbasics.java.Car

class CarKt (var model:String, val dieselEngine:Boolean) {

    var color: String = "yellow"
    private val seatCount = 4

    lateinit var maker: String

    init {
        val car = Car("b", true)
        car.model = "a"
    }
}