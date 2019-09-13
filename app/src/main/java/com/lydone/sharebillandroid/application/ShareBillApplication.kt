package com.lydone.sharebillandroid.application

import android.app.Application
import android.util.Log
import com.lydone.sharebillandroid.di.AppComponent
import com.lydone.sharebillandroid.di.AppModule
import com.lydone.sharebillandroid.di.DaggerAppComponent
import io.reactivex.plugins.RxJavaPlugins



class ShareBillApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler { throwable ->
            Log.w("DefaultErrorHandler", throwable.message, throwable)
        }
        appComponent = DaggerAppComponent.builder().appModule(AppModule()).build()
    }

    companion object {
        private var appComponent: AppComponent? = null
        fun getAppComponent(): AppComponent {
            return appComponent!!
        }
    }
}