package com.adr.smartorder.presenter

import android.util.Log
import com.adr.smartorder.model.PostLoginResponse
import com.adr.smartorder.model.api.APIClient
import com.adr.smartorder.model.api.APIInterface
import com.adr.smartorder.view.ILoginActivityView
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivityPresenter(private val iLoginActivityView: ILoginActivityView) :
    ILoginActivityPresenter {

    companion object {
        var currentToken = ""
    }

    override fun userLogin(email: String, password: String) {
//        val firebaseAuth = FirebaseAuth.getInstance()
//        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
//            if (it.isSuccessful){
//                iLoginActivityView.onLoginSuccess()
//            } else {
//                iLoginActivityView.onLoginFailed()
//            }
//        }

        val headerLogin = HashMap<String, String>()
        headerLogin["Key-Signature-Post"] = "754c9902df14ebd24df5d6fe367f0788815094ad"
        headerLogin["Key-Id"] = "100"
        headerLogin["Content-Type"] = "application/x-www-form-urlencoded"

        APIClient().client().create(APIInterface::class.java)
            .postLogin(headerLogin, "postMerchantUserLogin", password, email)
            .enqueue(object : Callback<PostLoginResponse>{
                override fun onFailure(call: Call<PostLoginResponse>, t: Throwable) {
                    iLoginActivityView.onLoginFailed()
                }

                override fun onResponse(
                    call: Call<PostLoginResponse>,
                    response: Response<PostLoginResponse>
                ) {
                    if (response.isSuccessful){
                        if (response.body() != null) {
                            if (response.body()?.error_code == 0) {
                                if (response.body()?.payload != null) {
                                    currentToken = response.body()?.payload!!.token
                                } else {
                                    iLoginActivityView.onLoginFailed()
                                }
                                iLoginActivityView.onLoginSuccess()
                            } else {
                                iLoginActivityView.onLoginFailed()
                            }
                        }
                    }
                }

            })
    }

    override fun isUserLoggedIn() {
//        val firebaseUser = FirebaseAuth.getInstance().currentUser
//        if (firebaseUser != null) {
//            iLoginActivityView.onUserLoggedIn(true)
//        } else {
//            iLoginActivityView.onUserLoggedIn(false)
//        }
    }
}