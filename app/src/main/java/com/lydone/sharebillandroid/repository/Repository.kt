package com.lydone.sharebillandroid.repository

import io.reactivex.Single

interface Repository {
    fun getHelloString(): Single<String>
}