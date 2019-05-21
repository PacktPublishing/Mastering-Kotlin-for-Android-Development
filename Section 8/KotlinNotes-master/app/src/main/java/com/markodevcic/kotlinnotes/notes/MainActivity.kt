package com.markodevcic.kotlinnotes.notes

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.markodevcic.kotlinnotes.R
import com.markodevcic.kotlinnotes.data.Note
import com.markodevcic.kotlinnotes.utils.findAsync
import io.realm.Realm
import io.realm.RealmResults
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

	private lateinit var realm: Realm
	private lateinit var mainUi: MainUi
	private lateinit var notes: RealmResults<Note>
	private lateinit var drawerLayout: DrawerLayout
	private lateinit var notesAdapter: NotesAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		realm = Realm.getDefaultInstance()
		notes = realm.findAsync { /*empty query, find all notes */ }
		notesAdapter = NotesAdapter(notes, true)
		mainUi = MainUi(notesAdapter)
		mainUi.setContentView(this)

		drawerLayout = find(R.id.drawer_layout)
		val toolbar = find<Toolbar>(R.id.main_toolbar)
		setSupportActionBar(toolbar)

		val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,
				R.string.app_name, R.string.app_name)
		drawerLayout.addDrawerListener(toggle)
		toggle.syncState()
	}

	override fun onDestroy() {
		super.onDestroy()
		realm.close()
	}

	override fun onBackPressed() {
		if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
			drawerLayout.closeDrawer(GravityCompat.START)
		} else {
			super.onBackPressed()
		}
	}

	override fun onNavigationItemSelected(item: MenuItem): Boolean {
		val results = when (item.itemId) {
			R.id.menu_filder_pending -> realm.findAsync<Note> { equalTo("isDone", false) }
			R.id.menu_filter_favorites -> realm.findAsync {
				equalTo("isDone", false)
				equalTo("isFavorite", true)
			}
			R.id.menu_filter_done -> realm.findAsync { equalTo("isDone", true) }
			R.id.menu_filter_all -> realm.findAsync {  }
			else -> throw IllegalArgumentException("unknown ID")
		}
		supportActionBar?.title = item.title
		notesAdapter.onResultsChanged(results)
		drawerLayout.closeDrawer(GravityCompat.START)
		return true
	}
}
