package br.com.concrete.testworkshopseptember18th

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        do_login.setOnClickListener {
            when {
                email.text.toString().isEmpty() -> showError(R.string.error_email_is_empty)
            }
        }
    }

    private fun showError(@StringRes messageRes: Int) {
        AlertDialog.Builder(this)
            .setMessage(messageRes)
            .show()
    }
}
