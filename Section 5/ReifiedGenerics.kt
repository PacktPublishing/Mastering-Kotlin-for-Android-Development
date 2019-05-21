@file:Suppress("unused", "UNUSED_VARIABLE")

fun <T : Any> newInstance(): T {
    //can't access Generic T parameter
    val clazz = T::class.java
}

fun <T : Any> newInstance(clazz: Class<T>): T {
    return clazz.newInstance()
}


fun <reified T: Any> reifiedNewInstance(): T {
    return T::class.java.newInstance()
}