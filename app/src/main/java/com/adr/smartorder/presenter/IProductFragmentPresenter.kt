package com.adr.smartorder.presenter

import com.adr.smartorder.model.PayloadProdGroupRes

interface IProductFragmentPresenter {
    fun getProductGroupList()
    fun onSearchFromList(search: String, listData: List<PayloadProdGroupRes>)
}