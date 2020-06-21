package com.adr.smartorder.view

interface IMainActivityView {
    fun chatPartner(avatar: String, name: String)
    fun onLogoutStatus(status: Boolean)
//    fun onSetData(data: ArrayList<UsersModel.User>)
    fun onContactClicked(userId: String)
}