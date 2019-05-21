@file:Suppress("RedundantIf")

package kotlinbasics.kotlin

fun isEven(n: Int): Boolean {
    val even = if (n % 2 == 0)
        true
     else {
        false
    }

    return even
//    return n % 2 == 0 ? true : false
}