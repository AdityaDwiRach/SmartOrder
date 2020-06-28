package com.adr.smartorder.model

data class PayloadLoginRes(
    val company_alias: String,
    val company_id: String,
    val company_logo: String,
    val company_name: String,
    val email: String,
    val first_login: String,
    val full_name: String,
    val module_customer: String,
    val module_inventory: String,
    val photo: String,
    val status: String,
    val stsrc: String,
    val token: String,
    val user_id: String,
    val user_type_id: String,
    val user_type_name: String
)