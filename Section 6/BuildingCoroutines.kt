@file:Suppress("unused")

import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.suspendCoroutine


fun getStringAsync(): Deferred<String> {
    return async(CommonPool) {
        //simulate something long running
        delay(2000)
        return@async "I'm deferred string"
    }
}

fun callGetStringAsync() {
    launch(Unconfined) {
        println("Calling async operation")
        val deferredString: Deferred<String> = getStringAsync()
        println("Waiting for completion")
        val value = deferredString.await() //suspension point
        println("Async operation complete, received value: $value")
    }
}

suspend fun AsyncOperation.asyncExecute(): String {
    return suspendCoroutine { continuation ->
         this.execute(object: Callback<String>{
             override fun onResult(result: String) {
                 continuation.resume(result)
             }

             override fun onError(fail: Exception) {
                 continuation.resumeWithException(fail)
             }
         })
    }
}









interface Callback<in T> {
    fun onResult(result: T)
    fun onError(fail: Exception)
}

class AsyncOperation {
    fun <T> execute(callback: Callback<T>) {
        Thread.sleep(1000)
        callback.onResult()
    }
}