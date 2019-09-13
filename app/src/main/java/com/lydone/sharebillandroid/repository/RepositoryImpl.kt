package com.lydone.sharebillandroid.repository

import io.reactivex.Single

class RepositoryImpl(private val cacheStorage: CacheStorage, private val apiService: ApiService) : Repository {
    override fun getHelloString(): Single<String> {
       return cacheStorage.getHelloStringFromCache()
    }
}