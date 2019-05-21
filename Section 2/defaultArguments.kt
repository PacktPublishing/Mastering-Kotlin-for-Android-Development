package kotlinbasics.kotlin

@JvmOverloads
fun searchFor(array: IntArray,
              startIndex: Int = 0,
              endIndex: Int = array.size -1,
              searchNumber: Number = 1): IntArray {

    //search implementation
    return array
}

class Test {
    fun call() {
        val array = intArrayOf()
        searchFor(array)
        searchFor(array, 0, 1, 1)
    }
}