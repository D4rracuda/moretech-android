package com.lydone.sharebillandroid.repository.network.models.responses

data class ResultResponse<T>(val data: T, val message: String, val timestamp: String)

data class TransactionIdResponse(val txId: String, val result: String)