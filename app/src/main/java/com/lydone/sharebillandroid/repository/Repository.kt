package com.lydone.sharebillandroid.repository

import com.lydone.sharebillandroid.repository.network.models.responses.InvoiceInfoResponse
import com.lydone.sharebillandroid.repository.network.models.responses.ResultResponse
import com.lydone.sharebillandroid.repository.network.models.responses.TransactionIdResponse
import io.reactivex.Single

interface Repository {
    fun getSessionId(
        addresses: List<String> = emptyList(),
        deviceId: String = "test_device_id",
        deviceType: Int = 1
    ): Single<ResultResponse<String>>

    fun getInvoiceId(
        fpsid: String,
        amount: Double,
        number: String,
        payer: String,
        currencyCode: Int = 810,
        description: String = ""
    ): Single<ResultResponse<TransactionIdResponse>>

    fun getInvoiceInfo(
        fpsid: String,
        number: String,
        recipient: String,
        currencyCode: Int = 810
    ): Single<ResultResponse<InvoiceInfoResponse>>
}