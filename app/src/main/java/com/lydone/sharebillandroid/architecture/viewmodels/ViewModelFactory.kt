package com.lydone.sharebillandroid.architecture.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lydone.sharebillandroid.awards.AwardsViewModel
import com.lydone.sharebillandroid.history.HistoryViewModel
import com.lydone.sharebillandroid.main.MainViewModel
import com.lydone.sharebillandroid.qr.QrCodeViewModel
import com.lydone.sharebillandroid.repository.Repository
import com.lydone.sharebillandroid.share_bill.ShareBillViewModel
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(repository) as T
            }
            modelClass.isAssignableFrom(AwardsViewModel::class.java) -> {
                AwardsViewModel(repository) as T
            }
            modelClass.isAssignableFrom(HistoryViewModel::class.java) -> {
                HistoryViewModel(repository) as T
            }
            modelClass.isAssignableFrom(ShareBillViewModel::class.java) -> {
                ShareBillViewModel(repository) as T
            }
            modelClass.isAssignableFrom(QrCodeViewModel::class.java) -> {
                QrCodeViewModel(repository) as T
            }
            else -> throw IllegalStateException("Provide create method fo viewModel's factory")
        }
    }
}