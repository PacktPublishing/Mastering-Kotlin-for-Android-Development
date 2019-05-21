@file:Suppress("unused")

import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class StringDelegate {
    var string by Delegate("Kotlin")
}

class Delegate (var value:String): ReadWriteProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        println("Get Called on Delegate, returning $value")
        return value
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        println("Set Called on Delegate with value: $value")
        this.value = value
    }
}

class InjectedProperty<out T>(private val clazz: Class<T>) : ReadOnlyProperty<Any, T> {

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        //in a real world library this call would go to a container that knows how to create this Type
        //to simplify, we always create a new instance with reflection
        return clazz.newInstance()
    }
}

inline fun <reified T : Any> injected(): InjectedProperty<T> {
    return InjectedProperty(T::class.java)
}

class DelegatedProperties {

    val any by injected<Any>()

    //what compiler generates
    private val anyInjectedProperty = InjectedProperty(Any::class.java)
    val anyProp: Any
        get() = anyInjectedProperty.getValue(this, this::anyProp)


}

class StandardLibDelegatedProperties {
    val string by lazy { "lazy String" }

    fun localDelegatedProperties(someCondition: Boolean) {
        val localLazyString by lazy { "local lazy String" }

        if (someCondition) {
            println(localLazyString)
        }
    }
}