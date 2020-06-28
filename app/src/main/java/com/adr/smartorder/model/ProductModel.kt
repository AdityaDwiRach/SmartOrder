package com.adr.smartorder.model

data class ProductModel(
    val productGroup: String = "",
    val photo: String = "",
    val productName: String = "",
    val productPrice: Int = 0,
    val productTag: String = "",
    val description: String = ""
)