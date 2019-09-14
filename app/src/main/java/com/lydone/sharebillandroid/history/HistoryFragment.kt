package com.lydone.sharebillandroid.history

import com.lydone.sharebillandroid.R
import com.lydone.sharebillandroid.architecture.fragments.FragmentWithViewModelAndNavController

class HistoryFragment : FragmentWithViewModelAndNavController<HistoryViewModel>() {
    override val viewModelClass: Class<HistoryViewModel> = HistoryViewModel::class.java
    override val layout: Int = R.layout.fragment_history
}