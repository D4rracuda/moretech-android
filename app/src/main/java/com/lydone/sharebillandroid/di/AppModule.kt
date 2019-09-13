package com.lydone.sharebillandroid.di

import com.google.gson.Gson
import com.lydone.sharebillandroid.architecture.viewmodels.ViewModelFactory
import com.lydone.sharebillandroid.repository.*
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideRepository(cacheStorage: CacheStorage, apiService: ApiService): Repository {
        return RepositoryImpl(cacheStorage, apiService)
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://google.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideCacheStorage(): CacheStorage {
        return CacheStorageImpl()
    }

    @Provides
    @Singleton
    fun provideViewModelFactory(repository: Repository): ViewModelFactory {
        return ViewModelFactory(repository)
    }

}