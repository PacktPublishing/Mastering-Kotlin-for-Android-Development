package kotlinbasics.kotlin

fun searchForNamed(array: IntArray,
                   startIndex: Int = 0,
                   endIndex: Int = array.size,
                   searchNumber: Number = 1): IntArray {

    //search implementation
    return array
}

class NamedArguments {
    fun call() {
        val targetArray = intArrayOf(1,2,3,4)

        searchForNamed(startIndex = 0, searchNumber = 2,
                endIndex = targetArray.size - 1, array = targetArray)
    }
}