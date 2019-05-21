package com.markodevcic.kotlinnotes.notes

import android.view.ViewGroup
import com.markodevcic.kotlinnotes.data.Note
import io.realm.RealmRecyclerViewAdapter
import io.realm.RealmResults
import org.jetbrains.anko.AnkoContext

class NotesAdapter(private var notes: RealmResults<Note>, autoUpdate: Boolean) : RealmRecyclerViewAdapter<Note, NotesViewHolder>(notes, autoUpdate) {

	override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
		val note = notes[position]
		holder.bind(note)
	}

	override fun getItemCount(): Int {
		return notes.size
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
		return NotesViewHolder(NotesUi().createView(AnkoContext.create(parent.context, parent)))
	}

	fun onResultsChanged(results: RealmResults<Note>) {
		notes = results
		super.updateData(notes)
	}
}