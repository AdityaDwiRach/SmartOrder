package com.adr.smartorder.view

interface ILoginActivityView {
    fun onLoginSuccess()
    fun onLoginFailed()
    fun onUserLoggedIn(isUserLoggedIn: Boolean)
}