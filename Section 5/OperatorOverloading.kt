@file:Suppress("unused", "UNUSED_VARIABLE")

data class Numeric(val value: Int) {

    operator fun plus(other: Numeric): Numeric {
        return Numeric(value + other.value)
    }

    operator fun times(other: Numeric): Numeric {
        return Numeric(value * other.value)
    }

    operator fun plus(num: Number): Numeric {
        return Numeric(value + num.toInt())
    }
}

//extension function with operator overloading
operator fun Char.times(multiplier: Int): String {
    return this.toString().repeat(multiplier)
}

fun examples() {
    val n1 = Numeric(10)
    val n2 = Numeric(20)
    val n3 = n1 + n2 //n3 has value 30
    val n4 = n1 * n2 //n4 has value 200
    val n5 = n1 + 10 //n5 has value 20

    println('A' * 3) //prints AAA

    //Collections have extension methods that overload operators
    val stringList = ArrayList<String>()
    stringList += "Kotlin"

    val anotherList = listOf("Java")
    val combinedLists = anotherList + stringList //New list has Kotlin and Java

    println(stringList[0]) //prints Kotlin
    stringList[0] = "Java" //sets Java at 0 index

    val map = mapOf(1 to "Kotlin")
    println(map[1]) //prints Kotlin

    println("Kotlin" in stringList) //prints true
}