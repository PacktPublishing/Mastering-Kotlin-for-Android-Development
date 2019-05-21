package com.markodevcic.kotlinnotes.notes

import android.support.v4.content.ContextCompat
import android.support.v4.view.GravityCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import com.markodevcic.kotlinnotes.R
import com.markodevcic.kotlinnotes.createnote.CreateNoteActivity
import com.markodevcic.kotlinnotes.utils.launchActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.floatingActionButton
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.drawerLayout

class MainUi(private var notesAdapter: NotesAdapter) : AnkoComponent<MainActivity> {

	override fun createView(ui: AnkoContext<MainActivity>): View {
		return with(ui) {
			drawerLayout {
				id = R.id.drawer_layout
				fitsSystemWindows = true

				coordinatorLayout {
					toolbar {
						popupTheme = R.style.AppTheme_PopupOverlay
						id = R.id.main_toolbar
						backgroundResource = R.color.colorPrimary
						setContentInsetsAbsolute(20, 0)
						elevation = dip(4).toFloat()
						setTitleTextColor(ContextCompat.getColor(ui.ctx, R.color.primary_text_default_material_dark))
						title = ui.ctx.getString(R.string.app_name)
					}.lparams(width = matchParent) {
						val tv = TypedValue()
						if (ui.owner.theme.resolveAttribute(R.attr.actionBarSize, tv, true)) {
							height = TypedValue.complexToDimensionPixelSize(tv.data, resources.displayMetrics)
						}
					}
					textView {
						id = R.id.no_items_text
						textResource = R.string.no_items
						gravity = Gravity.CENTER_HORIZONTAL
						visibility = View.GONE
					}
					scrollView {
						verticalPadding = dimen(R.dimen.activity_vertical_margin)
							recyclerView {
								id = R.id.recyclerview
								layoutManager = LinearLayoutManager(ui.owner)
								adapter = notesAdapter
								addItemDecoration(DividerItemDecoration(ui.ctx, DividerItemDecoration.VERTICAL))
							}
					}.lparams(width = matchParent, height = matchParent)

					floatingActionButton {
						imageResource = R.drawable.ic_plus_one_white
						backgroundColor = ContextCompat.getColor(ui.owner, R.color.colorAccent)
						setOnClickListener {
							ui.owner.launchActivity<CreateNoteActivity>()
						}
					}.lparams {
						margin = resources.getDimensionPixelSize(R.dimen.fab_margin)
						gravity = Gravity.BOTTOM or GravityCompat.END
					}
				}
				navigationView {
					fitsSystemWindows = true
					setNavigationItemSelectedListener(ui.owner)
					inflateHeaderView(R.layout.nav_header_main)
					inflateMenu(R.menu.activity_main_drawer)
				}.lparams(height = matchParent, gravity = GravityCompat.START)
			}
		}
	}
}