package com.adr.smartorder.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.adr.smartorder.R
import com.adr.smartorder.presenter.LoginActivityPresenter
import kotlinx.android.synthetic.main.activity_login.*
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity(), ILoginActivityView {

    private val presenter by lazy { LoginActivityPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter.isUserLoggedIn()

        val emailRegex = "^(?=.*[a-z])(?=.*[@])(?=.*[.])(?=\\S+$).{6,}$"
        val passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$"

        et_login_email.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null && s.isNotEmpty()) {
                    if (!Pattern.matches(emailRegex, s)) {
                        et_login_email.error = "Please check your email again."
                    } else {
                        et_login_email.error = null
                    }
                }
            }

        })

        et_login_password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null && s.isNotEmpty()) {
                    if (!Pattern.matches(passwordRegex, s)) {
                        et_login_password.error = "Please check your password again."
                    } else {
                        et_login_password.error = null
                    }
                }
            }

        })

        btn_login_login.setOnClickListener {
            val email = et_login_email.text.toString()
            val password = et_login_password.text.toString()

            if (email.isEmpty() || email.isBlank()) {
                et_login_email.error = "This form must not be empty."
            } else if (password.isEmpty() || password.isBlank()) {
                et_login_password.error = "This form must not be empty"
            } else {
                presenter.userLogin(email, password)
            }
        }

        tv_login_forgot_password.setOnClickListener{
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
    }

    override fun onLoginSuccess() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onLoginFailed() {
        Toast.makeText(
            this,
            "Login failed. Please chek your email & password then try again.",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onUserLoggedIn(isUserLoggedIn: Boolean) {
        if (isUserLoggedIn) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}