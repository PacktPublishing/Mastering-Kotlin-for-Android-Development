@file:Suppress("unused", "UNUSED_VARIABLE")

package classes

data class User(val name: String, val country: String)

fun equalsCheck() {
    val user1 = User("John", "US")
    val user2 = User("John", "US")

    //prints:
    //Are users User(name=John, country=US) and User(name=John, country=US) equal: true
    println("Are users $user1 and $user2 equal: ${user1 == user2}")
    println("Are users $user1 and $user2 reference equal: ${user1 === user2}")
}

fun copy() {
    val usUser = User("John", "US")
    val germanUser = usUser.copy(country = "Germany")
}

