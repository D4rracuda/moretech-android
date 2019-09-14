package com.lydone.sharebillandroid.history

import android.os.Bundle
import android.view.View
import androidx.navigation.ui.NavigationUI
import com.lydone.sharebillandroid.R
import com.lydone.sharebillandroid.architecture.fragments.FragmentWithViewModelAndNavController
import kotlinx.android.synthetic.main.fragment_history.*

class HistoryFragment : FragmentWithViewModelAndNavController<HistoryViewModel>() {
    override val viewModelClass: Class<HistoryViewModel> = HistoryViewModel::class.java
    override val layout: Int = R.layout.fragment_history

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NavigationUI.setupWithNavController(toolbar_history, navController)

    }
}