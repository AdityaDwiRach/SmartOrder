package com.adr.smartorder.view.fragment

import com.adr.smartorder.model.PayloadProdGroupRes

interface IProductView {
    fun onSuccessGetList(listData: List<PayloadProdGroupRes>)
    fun onFailedGetList(error: String)
    fun onSuccessSearch(listData: List<PayloadProdGroupRes>)
    fun onFailedSearch(error: String)
}