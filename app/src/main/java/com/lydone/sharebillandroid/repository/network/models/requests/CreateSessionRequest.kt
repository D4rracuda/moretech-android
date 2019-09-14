package com.lydone.sharebillandroid.repository.network.models.requests

data class CreateSessionRequest(
    val addresses: List<String> = emptyList(),
    val deviceId: String = "test_device_id",
    val deviceType: Int = 1
)