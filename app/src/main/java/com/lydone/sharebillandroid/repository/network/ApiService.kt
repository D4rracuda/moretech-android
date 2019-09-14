package com.lydone.sharebillandroid.repository.network

import com.lydone.sharebillandroid.repository.network.models.requests.CreateSessionRequest
import com.lydone.sharebillandroid.repository.network.models.responses.ResultResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/api/v1/session")
    fun getSessionId(@Body sessionCreateRequest: CreateSessionRequest): Single<ResultResponse>

    @POST("/api/v1/invoice")
    fun get
}