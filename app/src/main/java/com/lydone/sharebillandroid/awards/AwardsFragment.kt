package com.lydone.sharebillandroid.awards

import android.os.Bundle
import android.view.View
import androidx.navigation.ui.NavigationUI
import com.lydone.sharebillandroid.R
import com.lydone.sharebillandroid.architecture.fragments.FragmentWithViewModelAndNavController
import kotlinx.android.synthetic.main.fragment_awards.*

class AwardsFragment : FragmentWithViewModelAndNavController<AwardsViewModel>() {
    override val viewModelClass: Class<AwardsViewModel> = AwardsViewModel::class.java
    override val layout: Int = R.layout.fragment_awards

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NavigationUI.setupWithNavController(toolbar_awards, navController)

    }
}