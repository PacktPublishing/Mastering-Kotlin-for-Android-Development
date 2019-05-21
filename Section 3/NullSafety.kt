@file:Suppress("unused")

package classes

var string: String = "something"

var nullableString: String? = null

fun assignString() {
//    string = null
    nullableString = null
}

fun explicitNullAssertion() {
    val len = nullableString!!.length
}

