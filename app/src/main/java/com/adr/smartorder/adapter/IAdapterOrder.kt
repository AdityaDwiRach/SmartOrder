package com.adr.smartorder.adapter

import com.adr.smartorder.model.MockDataOrder

interface IAdapterOrder {
    interface IAdapterOrderModel {
        fun setListData(listData: List<MockDataOrder.MockDataOrder>)
        fun getSizeData(): Int
        fun getListData(): List<MockDataOrder.MockDataOrder>
    }

    interface IAdapterOrderView {
        fun refreshData()
    }
}