package com.adr.smartorder.adapter

import com.adr.smartorder.model.PayloadProdGroupRes

interface IAdapterProductModel {
    fun setListData(listData: List<PayloadProdGroupRes>)
    fun getSizeData(): Int
    fun getListData(): List<PayloadProdGroupRes>
}

interface IAdapterProductView {
    fun refreshData()
}