package com.lydone.sharebillandroid.application.test

import androidx.lifecycle.MutableLiveData
import com.lydone.sharebillandroid.architecture.viewmodels.ViewModelWithRepository
import com.lydone.sharebillandroid.repository.Repository
import io.reactivex.schedulers.Schedulers

class TestViewModel(repository: Repository) : ViewModelWithRepository(repository) {
    private val helloStringMutableLiveData = MutableLiveData<String>()
    val helloStringLiveData get() = helloStringMutableLiveData
    init {
        repository.getHelloString()
            .subscribeOn(Schedulers.io())
            .subscribe ({
                helloStringMutableLiveData.postValue(it)
            },{}).autoDispose()
    }

}