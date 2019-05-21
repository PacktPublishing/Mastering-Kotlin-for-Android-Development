package kotlinbasics.kotlin

fun iterateFromTo() {
    for (i in 1..200) {
        println(i)
    }
}

fun iterateBackwards() {
    for (i in 1000 downTo 500 step 100) {
        println(i)
    }
}

fun iterateCollection(collection: Collection<Int>) {
    for (i in collection) {
        println(i)
    }
}

fun iterateMap(map: Map<Int, String>) {
    for ((k, v) in map) {
        println("Key: $k, Value: $v")
//        println("Key: " + k.toString())
    }
}