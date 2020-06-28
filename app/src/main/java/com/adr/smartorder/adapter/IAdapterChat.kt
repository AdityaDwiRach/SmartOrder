package com.adr.smartorder.adapter

import com.adr.smartorder.model.MockDataChat
import com.adr.smartorder.model.PayloadProdGroupRes

interface IAdapterChatModel {
    fun setListData(listData: List<List<MockDataChat.MockDataChat>>)
    fun getSizeData(): Int
    fun getListData(): List<List<MockDataChat.MockDataChat>>
}

interface IAdapterChatView {
    fun refreshData()
}