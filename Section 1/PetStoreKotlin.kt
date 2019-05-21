package com.markodevcic.javakotlincomparison

import android.view.View

class PetStoreKotlin (var pets: List<Pet>) {
	fun findPet(name: String): Pet? {
		View().setOnClickListener {
			//view clicked
		}
		return pets.firstOrNull { pet -> pet.name == name }
	}
}