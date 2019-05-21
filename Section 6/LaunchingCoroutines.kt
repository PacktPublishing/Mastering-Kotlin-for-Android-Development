@file:Suppress("unused", "UNUSED_VARIABLE")

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.swing.Swing

suspend fun asyncString(): String {
    delay(1000)
    return "Coroutine"
}

fun callCoroutine() {
    //can't call a suspend function without suspend keyword
    val foo = asyncString()
}

fun callCoroutineAsync() {
    val job: Job = launch(Swing) {
        println("Entered suspendable function, calling async operation")
        val value = asyncString()
        println("Async operation done, got value: $value")
    }

    launch(Unconfined) {
        //Continuations are resumed on whatever thread was used for suspending function
    }

    launch(CommonPool) {
        //Uses CPU bound thread pool for executing tasks
    }

    runBlocking {
        //Blocks the current thread until the coroutine completes
    }
}
