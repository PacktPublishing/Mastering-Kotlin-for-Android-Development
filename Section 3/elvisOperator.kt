@file:Suppress("unused", "UNUSED_VARIABLE", "ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE", "UNUSED_VALUE", "IfThenToSafeAccess", "IfThenToElvis")

package classes

fun elvisOperator(input: String?) {
    var len = input?.length ?: -1

    len = if (input != null) {
        input.length
    } else {
        -1
    }

    val two = null ?: 2
}