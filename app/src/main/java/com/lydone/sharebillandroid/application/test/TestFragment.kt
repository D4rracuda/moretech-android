package com.lydone.sharebillandroid.application.test

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.lydone.sharebillandroid.R
import com.lydone.sharebillandroid.architecture.fragments.FragmentWithViewModelAndNavController
import kotlinx.android.synthetic.main.fragment_test.*

class TestFragment : FragmentWithViewModelAndNavController<TestViewModel>() {
    override val viewModelClass: Class<TestViewModel> = TestViewModel::class.java
    override val layout: Int = R.layout.fragment_test

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.helloStringLiveData.observe(this, Observer {
            test_text.text = it
        })
    }
}