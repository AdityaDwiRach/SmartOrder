package com.adr.smartorder.presenter

interface ILoginActivityPresenter {
    fun userLogin(email: String, password: String)
    fun isUserLoggedIn()
}