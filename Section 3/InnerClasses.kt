@file:Suppress("unused")

package classes

class Outer {
    private var name = ""

    class Inner {
        fun changeName(newName: String) {
//            name = newName
        }
    }
}

class AnotherOuter {
    private var name = ""

    inner class Inner {
        fun changeName(newName: String) {
            name = newName
        }
    }
}
