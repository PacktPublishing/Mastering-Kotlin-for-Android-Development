@file:Suppress("unused", "UNUSED_PARAMETER", "UNUSED_VARIABLE")

val names: List<String> = ArrayList()

class GenericClass<T>(private var item: T) {

    fun update(newItem: T) {
        item = newItem
    }
}

fun stringClass() {
    val generic = GenericClass("generic")
    generic.update("updated")
    generic.update(arrayOf("")) //won't compile with diferent type argument

    val anotherGeneric = GenericClass<Int>("generic") //won't compile with diferent type argument
}

class NonGenericClass {
    fun <T> genericFunction(item: T) {

    }
}

fun <K, V> multipleTypes(key: K, value: V) {

}

fun <T> T.doSomething() {

}

fun <V> execute(item: V, init: V.() -> Unit) {

}