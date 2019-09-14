package com.lydone.sharebillandroid.awards

import com.lydone.sharebillandroid.R
import com.lydone.sharebillandroid.architecture.fragments.FragmentWithViewModelAndNavController

class AwardsFragment : FragmentWithViewModelAndNavController<AwardsViewModel>() {
    override val viewModelClass: Class<AwardsViewModel> = AwardsViewModel::class.java
    override val layout: Int = R.layout.fragment_awards
}