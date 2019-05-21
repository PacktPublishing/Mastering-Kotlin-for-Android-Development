@file:Suppress("unused")

val action: () -> Unit = { println("Function assigned to a property") }

val incrementFunction: (Int) -> Int = { i -> i + 1 }


fun createAction(): () -> Unit {
    return { println("I'm a lambda") }
}


fun consumeAction(action: () -> Unit) {
    action()
    action.invoke()
}


fun passingFunctionTypes() {
    consumeAction(action)
    consumeAction { println("Lambda passed to function") }
    consumeAction(::anotherAction)

    val actionHolder = ActionHolder()
    consumeAction(actionHolder::action)
}

fun anotherAction() {
    println("Member reference")
}

class ActionHolder {
    fun action() = print("Member reference called from class")
}