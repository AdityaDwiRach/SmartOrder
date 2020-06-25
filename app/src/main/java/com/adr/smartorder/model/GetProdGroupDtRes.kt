package com.adr.smartorder.model

data class GetProdGroupDtRes (
    val error_code: Int,
    val message: String,
    val payload: PayloadProdGroupRes
)