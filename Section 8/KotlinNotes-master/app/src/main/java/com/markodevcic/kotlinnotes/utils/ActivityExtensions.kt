@file:Suppress("UNCHECKED_CAST")

package com.markodevcic.kotlinnotes.utils

import android.app.Activity
import android.view.View
import android.widget.Toast

fun <T : View> Activity.find(id: Int): T = this.findViewById(id) as T

fun Activity.showToast(content: String, length: Int = Toast.LENGTH_LONG) {

}
