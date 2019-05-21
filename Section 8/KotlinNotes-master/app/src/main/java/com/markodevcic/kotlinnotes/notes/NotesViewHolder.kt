package com.markodevcic.kotlinnotes.notes

import android.support.v7.widget.RecyclerView
import android.text.Spannable
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import com.markodevcic.kotlinnotes.R
import com.markodevcic.kotlinnotes.data.Note
import io.realm.Realm
import org.jetbrains.anko.find
import java.text.DateFormat
import java.util.*

class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
	private val titleText = itemView.find<TextView>(R.id.notes_item_title)
	private val contentText = itemView.find<TextView>(R.id.notes_item_content)
	private val dateText = itemView.find<TextView>(R.id.notes_item_date)
	private val favorite = itemView.find<ImageView>(R.id.notes_item_favorite)
	private val menuButton = itemView.find<ImageButton>(R.id.notes_item_menu)
	private var isExpanded = false

	fun bind(note: Note) {
		contentText.setOnClickListener {
			if (isExpanded) {
				contentText.maxLines = 1
			} else {
				contentText.maxLines = Int.MAX_VALUE
			}
			isExpanded = !isExpanded
		}
		menuButton.setOnClickListener { view ->
			val popupMenu = PopupMenu(view.context, view)
			popupMenu.setOnMenuItemClickListener { item ->
				when (item.itemId) {
					R.id.action_favorite -> {
						toggleIsFavorite(note)
						true
					}
					R.id.action_done -> {
						toggleIsDone(note)
						true
					}
					else -> false
				}
			}
			popupMenu.inflate(R.menu.menu_item_note)
			popupMenu.show()
		}

		if (note.isDone) {
			setSpan(titleText, note.title)
			setSpan(contentText, note.note)
		} else {
			titleText.text = note.title
			contentText.text = note.note
		}
		val formatter = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault())
		dateText.text = formatter.format(Date(note.createdAt))
		if (note.isFavorite) {
			favorite.visibility = View.VISIBLE
		} else {
			favorite.visibility = View.INVISIBLE
		}
	}

	private fun toggleIsFavorite(note: Note) {
		Realm.getDefaultInstance().use { realm ->
			realm.executeTransaction {
				note.isFavorite = !note.isFavorite
			}
		}
	}

	private fun toggleIsDone(note: Note) {
		Realm.getDefaultInstance().use { realm ->
			realm.executeTransaction {
				note.isDone = !note.isDone
			}
		}
	}

	private fun setSpan(textView: TextView, text: String) {
		textView.setText(text, TextView.BufferType.SPANNABLE)
		val spannable = textView.text as Spannable
		spannable.setSpan(StrikethroughSpan(), 0, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
	}
}