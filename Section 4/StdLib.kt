@file:Suppress("unused", "UNUSED_VARIABLE")

fun filter() {
    val filtered = cars.filter { car -> car.type == "XYZ" }
}

fun map() {
    val productionYears = cars.map { car -> car.productionYear }
}

fun iterateAll() {
    cars.forEach { car -> println(car.type) }
}

fun any() {
    val hasOldCars = cars.any { car -> car.productionYear <= 2000 }
}

fun groupBy() {
    val carsByProductionYear = cars.groupBy { car -> car.productionYear }
}

fun multipleFunctions() {
    val count = (1..100).filter { i -> i % 2 == 0 }
            .map { i -> i * i }
            .count { it % 10 == 0 }
}

fun otherUsefulMethods(input: String?): String {
    checkNotNull(input) { "input can not be null" }
    input?.let { str -> println(str) }
    input?.let { str -> str + " ext" }?.also { print(it) }
    TODO("We'll finish this later")
}