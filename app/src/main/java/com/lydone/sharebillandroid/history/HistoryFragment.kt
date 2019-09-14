package com.lydone.sharebillandroid.history

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lydone.sharebillandroid.R
import com.lydone.sharebillandroid.architecture.fragments.FragmentWithViewModelAndNavController

class HistoryFragment : FragmentWithViewModelAndNavController<HistoryViewModel>() {
    override val viewModelClass: Class<HistoryViewModel> = HistoryViewModel::class.java
    override val layout: Int = R.layout.fragment_history
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar!!.title = "История"
    }
}