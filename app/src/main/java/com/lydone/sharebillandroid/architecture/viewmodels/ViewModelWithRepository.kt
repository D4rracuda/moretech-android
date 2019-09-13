package com.lydone.sharebillandroid.architecture.viewmodels

import com.lydone.sharebillandroid.repository.Repository

abstract class ViewModelWithRepository(private val repository: Repository) : BaseViewModel()