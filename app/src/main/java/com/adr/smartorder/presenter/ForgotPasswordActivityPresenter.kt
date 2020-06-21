package com.adr.smartorder.presenter

import com.adr.smartorder.view.IForgotPasswordView
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivityPresenter(private val iForgotPasswordView: IForgotPasswordView) :
    IForgotPasswordActivityPresenter {
    override fun userForgotPassword(email: String) {
        val firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.sendPasswordResetEmail(email)
            .addOnSuccessListener {
                iForgotPasswordView.onSuccessForgotPassword()
            }
            .addOnFailureListener {
                iForgotPasswordView.onFailedForgotPassword(it.message.toString())
            }
    }
}