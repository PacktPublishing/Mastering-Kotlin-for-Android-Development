@file:Suppress("unused", "UNUSED_VARIABLE", "UNUSED_PARAMETER", "ConvertTryFinallyToUseCall")

import java.io.Closeable

fun noRawTypes() {
    //no Raw Types in Kotlin
    val list: List = ArrayList()
}


fun wildcards(anyList: List<*>) {
    if (anyList.isNotEmpty()) {
        val firstItem = anyList[0]
    }
}

fun <T : Closeable> runAndClose(closable: Closeable, execute: Closeable.() -> Unit) {
    try {
        closable.execute()
    } finally {
        closable.close()
    }
}

fun <T> multipleConstraints(item: T) where T : Runnable, T: Closeable {

}
