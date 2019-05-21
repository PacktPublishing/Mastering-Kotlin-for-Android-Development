@file:Suppress("unused", "LoopToCallChain")


class Car(val type: String, val productionYear: Int)

val cars: List<Car> = ArrayList()

interface CarPredicate {
    fun filter(car: Car): Boolean
}

fun filterCars(carPredicate: CarPredicate): List<Car> {
    val result = ArrayList<Car>()
    for (c in cars) {
        if (carPredicate.filter(c)) {
            result.add(c)
        }
    }
    return result
}

fun filterOldCars() {
    val cars = filterCars(object : CarPredicate {
        override fun filter(car: Car): Boolean {
            return car.productionYear <= 2010
        }
    })
    //do something with old cars
}