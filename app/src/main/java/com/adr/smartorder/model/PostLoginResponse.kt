package com.adr.smartorder.model

data class PostLoginResponse(
    val error_code: Int,
    val message: String,
    val payload: PayloadLoginRes
)