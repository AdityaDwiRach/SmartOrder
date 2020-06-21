package com.adr.smartorder.presenter

import com.adr.smartorder.view.ILoginActivityView
import com.google.firebase.auth.FirebaseAuth

class LoginActivityPresenter(private val iLoginActivityView: ILoginActivityView):
    ILoginActivityPresenter {
    override fun userLogin(email: String, password: String) {
        val firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful){
                iLoginActivityView.onLoginSuccess()
            } else {
                iLoginActivityView.onLoginFailed()
            }
        }
    }

    override fun isUserLoggedIn() {
        val firebaseUser = FirebaseAuth.getInstance().currentUser
        if (firebaseUser != null){
            iLoginActivityView.onUserLoggedIn(true)
        } else {
            iLoginActivityView.onUserLoggedIn(false)
        }
    }
}