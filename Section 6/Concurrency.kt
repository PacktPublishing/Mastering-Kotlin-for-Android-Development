@file:Suppress("unused")

import kotlin.jvm.Synchronized

class Concurrency {

    @Volatile
    private var volatileString = "volatile"

    @Synchronized
    fun synchronizedAnnotation() {
        println("I'm synchronized")
    }

    fun synchronizedFunction() {
        synchronized(this) {
            println("I'm also synchronized")
        }
    }

}