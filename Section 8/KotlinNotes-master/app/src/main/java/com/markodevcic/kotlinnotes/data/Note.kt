package com.markodevcic.kotlinnotes.data

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Note : RealmObject() {

	@PrimaryKey
	var id = ""

	var note = ""

	var title = ""

	var createdAt = 0L

	var isFavorite = false

	var isDone = false

	companion object {
		fun newNote(): Note =  Note().apply {
			id = UUID.randomUUID().toString()
			createdAt = Date().time
		}
	}
}