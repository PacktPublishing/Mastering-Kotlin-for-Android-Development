package com.markodevcic.kotlinnotes

import android.app.Application
import io.realm.Realm

class NotesApplication : Application() {
	override fun onCreate() {
		super.onCreate()
		Realm.init(this)
	}
}