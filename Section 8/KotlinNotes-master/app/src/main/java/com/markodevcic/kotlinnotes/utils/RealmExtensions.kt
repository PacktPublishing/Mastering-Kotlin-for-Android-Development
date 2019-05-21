package com.markodevcic.kotlinnotes.utils

import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmQuery
import io.realm.RealmResults

inline fun <reified T : RealmObject> Realm.findAsync(init: RealmQuery<T>.() -> Unit) : RealmResults<T> {
	val query = this.where(T::class.java)
	query.init()
	return query.findAllAsync()
}