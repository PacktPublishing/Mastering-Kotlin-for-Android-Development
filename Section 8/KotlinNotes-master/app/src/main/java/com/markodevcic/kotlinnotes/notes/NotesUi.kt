package com.markodevcic.kotlinnotes.notes

import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.markodevcic.kotlinnotes.R
import org.jetbrains.anko.*

class NotesUi : AnkoComponent<ViewGroup> {
	override fun createView(ui: AnkoContext<ViewGroup>): View {
		return with(ui) {
			linearLayout {
				lparams(width = matchParent, height = wrapContent)
				orientation = LinearLayout.VERTICAL
				padding = dip(12)
				linearLayout {
					lparams(width = matchParent, height = wrapContent)
					orientation = LinearLayout.HORIZONTAL
					textView {
						textSize = 20f
						id = R.id.notes_item_title
						textColor = ContextCompat.getColor(ui.ctx, android.R.color.black)
					}.lparams(width = wrapContent, height = wrapContent)

					imageView {
						id = R.id.notes_item_favorite
						imageResource = R.drawable.ic_star_black
					}.lparams {
						leftMargin = dip(12)
						width = 35
						height = 35
					}

					textView {
						id = R.id.notes_item_date
					}.lparams {
						leftMargin = dip(12)
					}

					linearLayout {
						gravity = Gravity.END

						imageButton {
							id = R.id.notes_item_menu
							imageResource = R.drawable.ic_action_more_vert
							backgroundColor = ContextCompat.getColor(ui.ctx, android.R.color.transparent)
						}.lparams(width = dip(24), height = dip(24)) {
							margin = 0
							padding = 0
						}
					}.lparams(width = matchParent) {
						margin = 0
						padding = 0
					}
				}

				textView {
					textSize = 16f
					id = R.id.notes_item_content
					maxLines = 1
					ellipsize = TextUtils.TruncateAt.END
				}.lparams(width = wrapContent) {
					topMargin = dip(6)
				}

			}
		}
	}
}