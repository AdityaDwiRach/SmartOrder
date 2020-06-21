package com.adr.smartorder.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.adr.smartorder.R
import com.adr.smartorder.presenter.ForgotPasswordActivityPresenter
import kotlinx.android.synthetic.main.activity_forgot_password.*
import java.util.regex.Pattern

class ForgotPasswordActivity : AppCompatActivity(), IForgotPasswordView {

    private val presenter by lazy { ForgotPasswordActivityPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        setSupportActionBar(tlbar_main)
        supportActionBar?.title = "Forgot Password"

        val emailRegex = "^(?=.*[a-z])(?=.*[@])(?=.*[.])(?=\\S+$).{6,}$"

        et_forgot_email.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null && s.isNotEmpty()) {
                    if (!Pattern.matches(emailRegex, s)) {
                        et_forgot_email.error = "Please check your email again."
                    } else {
                        et_forgot_email.error = null
                    }
                }
            }

        })

        btn_forgot_submit.setOnClickListener {
            val email = et_forgot_email.text.toString()

            if (email.isEmpty() || email.isBlank()) {
                et_forgot_email.error = "This form must not be empty."
            } else {
                presenter.userForgotPassword(email)
            }
        }
    }

    override fun onFailedForgotPassword(error: String) {
        if (error.isEmpty()) {
            Toast.makeText(this, "Please check again your email.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSuccessForgotPassword() {
        finish()
    }
}