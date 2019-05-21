@file:Suppress("ObjectLiteralToLambda", "unused")

package classes

fun newRunnable(): Runnable {
    val foo = "foo"
    return object : Runnable {
        override fun run() {
            println(foo)
        }
    }
}