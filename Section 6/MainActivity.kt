package com.markodevcic.coroutinesexamoples

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.Toast
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class MainActivity : AppCompatActivity() {

	private val userService = UserService()
	private var job: Job? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		val toolbar = findViewById(R.id.toolbar) as Toolbar
		setSupportActionBar(toolbar)

		btnGetCountry.setOnClickListener {
			launch(UI) {
				val progressDialog = ProgressDialog(this@MainActivity)
				progressDialog.show()
				val country = userService.getUserCountryAsync().await()
				toast("Got country: $country")
				progressDialog.dismiss()
			}
		}

		btnGetFirstAndLastName.setOnClickListener {
			launch(UI) {
				val progressDialog = ProgressDialog(this@MainActivity)
				progressDialog.show()
				toast("Got name: " + userService.getUserFirstName().await() + " " + userService.getUserLastNameAsync().await())
				progressDialog.dismiss()
			}
		}

		btnIsUserLoggedIn.setOnClickListener {
			launch(UI) {
				val progressDialog = ProgressDialog(this@MainActivity)
				progressDialog.show()
				val fullName = userService.getUserFirstName().await() + " " + userService.getUserLastNameAsync().await()
				val isLoggedIn = userService.isUserLoggedIn(fullName).await()
				progressDialog.dismiss()
				toast("User is logged in: $isLoggedIn")
			}
		}

		btnFail.setOnClickListener {
			launch(UI) {
				try {
					userService.failAsync()
				} catch (fail: Throwable) {
					toast("Exception was thrown inside async method")
				}
			}
		}

		btnGetFirstName.setOnClickListener {
			job = launch(UI) {
				toast("Got first name: ${userService.getUserFirstName().await()}")
			}
		}

		btnCancel.setOnClickListener {
			job?.cancel()
		}
	}

	private fun toast(text: String) {
		Toast.makeText(this, text, Toast.LENGTH_LONG).show()
	}
}
