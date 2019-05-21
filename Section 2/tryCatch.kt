package kotlinbasics.kotlin

import java.io.InputStream


fun divideWithZero(n: Int) {
    try {
        val fail = n / 0
    } catch (e: Exception) {
        //exception caught
    } finally {

    }
}

@Throws
fun openStream(stream: InputStream) {
    stream.close()
}

