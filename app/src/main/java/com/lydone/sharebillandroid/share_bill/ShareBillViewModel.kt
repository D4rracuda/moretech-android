package com.lydone.sharebillandroid.share_bill

import androidx.lifecycle.MutableLiveData
import com.lydone.sharebillandroid.architecture.viewmodels.ViewModelWithRepository
import com.lydone.sharebillandroid.repository.Repository

class ShareBillViewModel(repository: Repository) : ViewModelWithRepository(repository) {
    val messageLiveData = MutableLiveData<String>()

    private val rabbitMQHandlerThread = RabbitMQHandlerThread(this)
    init {
        rabbitMQHandlerThread.start()
    }

    override fun onCleared() {
        rabbitMQHandlerThread.quit()
        super.onCleared()
    }

    fun sendMessage(message: String) {
        rabbitMQHandlerThread.postMessage(message)
    }

    fun processMessage(response: String) {
        messageLiveData.postValue(response)
    }
}