package com.adr.smartorder.view

interface IForgotPasswordView {
    fun onFailedForgotPassword(error: String)
    fun onSuccessForgotPassword()
}