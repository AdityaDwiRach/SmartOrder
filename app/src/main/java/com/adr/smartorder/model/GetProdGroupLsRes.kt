package com.adr.smartorder.model

data class GetProdGroupLsRes (
    val error_code: Int,
    val message: String,
    val payload: List<PayloadProdGroupRes>
)