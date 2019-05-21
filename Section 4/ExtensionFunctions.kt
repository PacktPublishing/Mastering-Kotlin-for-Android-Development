@file:Suppress("unused", "UNUSED_VARIABLE")

fun Car.isOld(): Boolean {
    return this.productionYear <= 2010
}

fun Car?.typeOrElse(orElse: String): String {
    return this?.type ?: orElse
}

fun callExtensionFunction(car: Car) {
    val isOld = car.isOld()
}