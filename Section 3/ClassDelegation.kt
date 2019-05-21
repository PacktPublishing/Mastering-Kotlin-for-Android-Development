@file:Suppress("unused")

package classes


class SteerableCar : Steerable {
    override fun steer() {
        println("I'm steering")
    }
}


class SteerableTruck(steerable: SteerableCar): Steerable by steerable


fun steerTruck(steerableTruck: SteerableTruck) {
    steerableTruck.steer()
}

