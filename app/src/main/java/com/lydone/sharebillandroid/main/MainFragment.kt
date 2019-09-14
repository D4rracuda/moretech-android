package com.lydone.sharebillandroid.main

import com.lydone.sharebillandroid.R
import com.lydone.sharebillandroid.architecture.fragments.FragmentWithViewModelAndNavController

class MainFragment : FragmentWithViewModelAndNavController<MainViewModel>() {
    override val viewModelClass: Class<MainViewModel> = MainViewModel::class.java
    override val layout: Int = R.layout.fragment_main
}