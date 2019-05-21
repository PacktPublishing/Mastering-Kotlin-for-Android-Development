package com.markodevcic.kotlinnotes.createnote

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.EditText
import com.markodevcic.kotlinnotes.R
import com.markodevcic.kotlinnotes.data.Note
import com.markodevcic.kotlinnotes.utils.find
import io.realm.Realm
import org.jetbrains.anko.toast

class CreateNoteActivity : AppCompatActivity() {

	private lateinit var titleText: EditText
	private lateinit var contentText: EditText

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_create_note)
		val toolbar = find<Toolbar>(R.id.toolbar)
		setSupportActionBar(toolbar)
		titleText = find(R.id.create_note_title_text)
		contentText = find(R.id.create_note_content_text)

		val fab = find<View>(R.id.fab)
		fab.setOnClickListener {
			if (saveNote()) {
				this.finish()
			}
		}
		supportActionBar?.setDisplayHomeAsUpEnabled(true)
	}

	private fun saveNote(): Boolean {
		val title = titleText.text.toString()
		val noteContent = contentText.text.toString()
		if (isInputValid(title, "title") && isInputValid(noteContent, "note content")) {
			Realm.getDefaultInstance().use { realm ->
				val note = Note.newNote()
				note.title = titleText.text.toString()
				note.note = contentText.text.toString()
				realm.executeTransactionAsync { r ->
					r.copyToRealmOrUpdate(note)
				}
			}
			return true
		}
		return false
	}

	private fun isInputValid(input: String?, inputTitle: String): Boolean {
		if (input.isNullOrBlank()) {
			this.toast("Input $inputTitle can not be blank")
			return false
		}
		return true
	}
}
