@file:Suppress("unused", "UNUSED_VARIABLE")


fun filterOldCarsLambda() {
    cars.filter { c : Car -> c.productionYear <= 2010 }
    cars.elementAtOrElse(1) { Car("default", 2011) }
}

fun lambdasAndClosures() {
    var counter = 0
    var incrementAction = { counter++ }
}

fun createRunnable(): Runnable = Runnable { print("hey I'm a Runnable created with lambda") }