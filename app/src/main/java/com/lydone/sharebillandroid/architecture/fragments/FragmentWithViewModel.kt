package com.lydone.sharebillandroid.architecture.fragments

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.lydone.sharebillandroid.architecture.viewmodels.BaseViewModel

abstract class FragmentWithViewModel<T: BaseViewModel>: BaseFragment() {
    abstract val viewModelClass: Class<T>
    protected lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[viewModelClass]
    }
}