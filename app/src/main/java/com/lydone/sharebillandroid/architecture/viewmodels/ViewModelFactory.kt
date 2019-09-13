package com.lydone.sharebillandroid.architecture.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lydone.sharebillandroid.application.test.TestViewModel
import com.lydone.sharebillandroid.repository.Repository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(TestViewModel::class.java) -> {
                return TestViewModel(
                    repository
                ) as T
            }
            else -> throw IllegalStateException("Provide create method fo viewModel's factory")
        }
    }
}