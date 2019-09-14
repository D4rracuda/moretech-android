package com.lydone.sharebillandroid.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lydone.sharebillandroid.architecture.fragments.FragmentWithViewModelAndNavController


class MainFragment : FragmentWithViewModelAndNavController<MainViewModel>() {
    override val viewModelClass: Class<MainViewModel> = MainViewModel::class.java
    override val layout: Int = com.lydone.sharebillandroid.R.layout.fragment_main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar!!.title = "Главная"
    }
}