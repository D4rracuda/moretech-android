package com.lydone.sharebillandroid.di

import com.lydone.sharebillandroid.MainActivity
import com.lydone.sharebillandroid.architecture.fragments.BaseFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragmentWithViewModel: BaseFragment)
}