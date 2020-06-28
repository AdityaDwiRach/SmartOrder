package com.adr.smartorder.model

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class MockDataOrder {

    @Parcelize
    data class MockDataOrder(
        val status: String,
        val noInvoice: String,
        val orderDate: String,
        val amountTotal: String,
        val nameIdProduct: String,
        val unitQty: String,
        val price: String,
        val note: String,
        val totalPrice: String,
        val address: String,
        val grandTotal: String
    ): Parcelable

    val data1 = MockDataOrder("Status 1", "No Invoice 1", "Order Date 1", "Amount Total 1", "Name/ID Product 1", "Qty 1", "Price 1", "Note 1","Total Price 1","Address 1","Grand Total 1")
    val data2 = MockDataOrder("Status 2", "No Invoice 2", "Order Date 2", "Amount Total 2", "Name/ID Product 2", "Qty 2", "Price 2", "Note 2","Total Price 2","Address 2","Grand Total 2")
    val data3 = MockDataOrder("Status 3", "No Invoice 3", "Order Date 3", "Amount Total 3", "Name/ID Product 3", "Qty 3", "Price 3", "Note 3","Total Price 3","Address 3","Grand Total 3")

    val listDataOrder = listOf(data1, data2, data3)
}