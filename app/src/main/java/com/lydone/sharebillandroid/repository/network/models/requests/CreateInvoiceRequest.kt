package com.lydone.sharebillandroid.repository.network.models.requests

data class CreateInvoiceRequest(
    val amount: Int,
    val number: String,
    val payer: String,
    val recipient: String,
    val currencyCode: Int = 810,
    val description: String = "test"
)