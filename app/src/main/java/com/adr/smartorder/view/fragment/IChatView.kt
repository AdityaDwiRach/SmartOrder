package com.adr.smartorder.view.fragment

import com.adr.smartorder.model.MockDataChat
import com.adr.smartorder.model.PayloadProdGroupRes

interface IChatView {
    fun onSuccessGetList(listData: List<List<MockDataChat.MockDataChat>>)
    fun onFailedGetList(error: String)
    fun onSuccessSearch(listData: List<List<MockDataChat.MockDataChat>>)
    fun onFailedSearch(error: String)
}