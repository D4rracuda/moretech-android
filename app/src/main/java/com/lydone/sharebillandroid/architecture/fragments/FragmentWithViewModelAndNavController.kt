package com.lydone.sharebillandroid.architecture.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.lydone.sharebillandroid.architecture.viewmodels.BaseViewModel

abstract class FragmentWithViewModelAndNavController<T : BaseViewModel> :
    FragmentWithViewModel<T>() {
    protected lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = findNavController()
    }
}