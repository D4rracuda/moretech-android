package com.lydone.sharebillandroid.repository.network

import com.lydone.sharebillandroid.repository.network.models.requests.CreateInvoiceRequest
import com.lydone.sharebillandroid.repository.network.models.requests.CreateSessionRequest
import com.lydone.sharebillandroid.repository.network.models.responses.InvoiceInfoResponse
import com.lydone.sharebillandroid.repository.network.models.responses.ResultResponse
import com.lydone.sharebillandroid.repository.network.models.responses.TransactionIdResponse
import io.reactivex.Single
import retrofit2.http.*

interface ApiService {
    @POST("/api/v1/session")
    fun getSessionId(@Body createSessionRequest: CreateSessionRequest): Single<ResultResponse<String>>

    @POST("/api/v1/invoice")
    fun getInvoiceId(@Header("FPSID") fpsid: String, @Body createInvoiceRequest: CreateInvoiceRequest): Single<ResultResponse<TransactionIdResponse>>

    @GET("/api/v1/invoice/{currencyCode}/{number}/{recipient}")
    fun getInvoiceInfo(
        @Header("FPSID") fpsid: String, @Path("number") number: String, @Path("recipient") recipient: String, @Path(
            "currencyCode"
        ) currencyCode: Int = 810
    ): Single<ResultResponse<InvoiceInfoResponse>>
}