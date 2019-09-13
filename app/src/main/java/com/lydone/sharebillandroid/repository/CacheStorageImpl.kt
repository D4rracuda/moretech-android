package com.lydone.sharebillandroid.repository

import io.reactivex.Single

class CacheStorageImpl : CacheStorage {
    override fun getHelloStringFromCache(): Single<String> {
        return Single.just("Hello world")
    }
}