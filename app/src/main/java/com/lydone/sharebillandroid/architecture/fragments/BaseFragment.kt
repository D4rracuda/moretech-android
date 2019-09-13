package com.lydone.sharebillandroid.architecture.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lydone.sharebillandroid.application.ShareBillApplication
import com.lydone.sharebillandroid.architecture.viewmodels.ViewModelFactory
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

abstract class BaseFragment : Fragment() {
    abstract val layout: Int
    @Inject
    protected lateinit var viewModelFactory: ViewModelFactory
    protected val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ShareBillApplication.getAppComponent().inject(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layout, container, false)
    }

    override fun onDestroyView() {
        compositeDisposable.dispose()
        super.onDestroyView()
    }

    fun Disposable.disposeOnDestroyView() {
        compositeDisposable.add(this)
    }
}