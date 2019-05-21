package kotlinbasics.kotlin

fun getAge(person: String): Int {
    return when (person) {
        "Mary" -> 21
        "John" -> 40
        "Sammy" -> 2
        "David" -> 19
        else -> throw IllegalArgumentException("unknown person")
    }
}

fun checkPerson(name: String) {
    when (name.length) {
          1,2,3 -> println("to short name")
          in 4..10 -> println("ok length")
    }
}