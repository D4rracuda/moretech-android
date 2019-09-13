package com.lydone.sharebillandroid.repository

import io.reactivex.Single

interface CacheStorage {
    fun getHelloStringFromCache(): Single<String>
}