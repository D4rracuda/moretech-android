package com.lydone.sharebillandroid.repository.network.models.requests

data class CreateInvoiceRequest(val amount: Double, val number: String, val payer: String, val currencyCode: Int = 810, val description: String = "")