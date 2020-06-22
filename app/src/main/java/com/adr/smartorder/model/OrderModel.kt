package com.adr.smartorder.model

data class OrderModel (
    val status: String = "",
    val invoiceNumber: Int = 0,
    val orderDate: Long = 0,
    val orderNote: String = "",
    val address: String = "",
    val grandTotal: Int = 0
)