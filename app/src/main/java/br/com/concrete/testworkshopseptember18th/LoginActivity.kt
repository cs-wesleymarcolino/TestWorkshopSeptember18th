package br.com.concrete.testworkshopseptember18th

import android.content.Intent
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private val passwordValidator = PasswordValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        do_login.setOnClickListener {
            when {
                email.text.toString().isEmpty() -> showError(R.string.error_email_is_empty)
                password.text.toString().isEmpty() -> showError(R.string.error_password_is_empty)
                !passwordValidator.isValid(password.text.toString()) -> showError(R.string.error_password_is_invalid)
                else -> {
                    val homeIntent = Intent(this@LoginActivity, HomeActivity::class.java)
                    startActivity(homeIntent)
                }
            }
        }
    }

    private fun showError(@StringRes messageRes: Int) {
        AlertDialog.Builder(this)
            .setMessage(messageRes)
            .show()
    }
}
