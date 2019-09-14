package com.lydone.sharebillandroid.repository

import com.lydone.sharebillandroid.repository.network.ApiService
import com.lydone.sharebillandroid.repository.network.models.requests.CreateInvoiceRequest
import com.lydone.sharebillandroid.repository.network.models.requests.CreateSessionRequest
import com.lydone.sharebillandroid.repository.network.models.responses.InvoiceInfoResponse
import com.lydone.sharebillandroid.repository.network.models.responses.ResultResponse
import com.lydone.sharebillandroid.repository.network.models.responses.TransactionIdResponse
import io.reactivex.Single

class RepositoryImpl(private val cacheStorage: CacheStorage, private val apiService: ApiService) :
    Repository {
    override fun getSessionId(
        addresses: List<String>,
        deviceId: String,
        deviceType: Int
    ): Single<ResultResponse<String>> {
        return apiService.getSessionId(CreateSessionRequest(addresses, deviceId, deviceType))
    }

    override fun getInvoiceId(
        fpsid: String,
        amount: Int,
        number: String,
        payer: String,
        recipient: String,
        currencyCode: Int,
        description: String
    ): Single<ResultResponse<TransactionIdResponse>> {
        return apiService.getInvoiceId(
            fpsid,
            CreateInvoiceRequest(amount, number, payer, recipient, currencyCode, description)
        )
    }

    override fun getInvoiceInfo(
        fpsid: String,
        number: String,
        recipient: String,
        currencyCode: Int
    ): Single<ResultResponse<InvoiceInfoResponse>> {
        return apiService.getInvoiceInfo(fpsid, number, recipient, currencyCode)
    }
}