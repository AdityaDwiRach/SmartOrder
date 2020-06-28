package com.adr.smartorder.model

data class BannerModel (
    val tag: String = "",
    val title: String = "",
    val startDate: Long = 0,
    val endDate: Long = 0,
    val image: String = "",
    val type: String = "",
    val linkDesc: String = ""
)