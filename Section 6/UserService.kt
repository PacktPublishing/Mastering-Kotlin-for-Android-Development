package com.markodevcic.coroutinesexamoples

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay

class UserService {

	fun getUserCountryAsync(): Deferred<String> = async(CommonPool) {
		delay(1500)
		"Sweden"
	}

	fun getUserFirstName(): Deferred<String> = async(CommonPool) {
		delay(1500)
		"John"
	}

	fun getUserLastNameAsync(): Deferred<String> = async(CommonPool) {
		delay(2000)
		"Doe"
	}

	fun isUserLoggedIn(fullName: String): Deferred<String> = async(CommonPool) {
		delay(750)
		"true"
	}

	suspend fun failAsync() {
		delay(1000)
		throw RuntimeException("I failed")
	}
}