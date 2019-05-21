@file:Suppress("unused")

package classes

object Singleton : Any(), Runnable {
    override fun run() {

    }

    val name = "Singleton"

    fun className(): String = this.javaClass.simpleName
}

fun foo() {
    println(Singleton.name)
}