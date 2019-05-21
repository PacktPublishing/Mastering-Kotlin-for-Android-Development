@file:Suppress("unused", "UNUSED_VARIABLE", "ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE", "UNUSED_VALUE", "IfThenToSafeAccess")

package classes

fun safeAccess(input: String?) {
//    val len = input.length
    var safeLen = input?.length

    safeLen = if (input != null) {
        input.length
    } else {
        null
    }

    val paddedLen = input?.padEnd(2)?.length
}