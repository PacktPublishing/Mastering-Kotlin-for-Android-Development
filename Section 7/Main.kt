@file:Suppress("UNUSED_VARIABLE")

class User(val age: Int)

fun main(args: Array<String>) {
    val user = User(20)

    val userValidator = Validator validates user forValue { it.age } withRules { age ->
        age lesserThan 30
        age greaterThan 10
        age notEqualTo 20
    } onError "User age should be less than 30, greater than 10 and not equal to 20"

    val result = userValidator.validate()
    print("Result: $result")
}