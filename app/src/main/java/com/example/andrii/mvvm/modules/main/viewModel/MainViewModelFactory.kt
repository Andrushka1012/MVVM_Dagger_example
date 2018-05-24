package com.example.andrii.mvvm.modules.main.viewModel

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.andrii.mvvm.modules.main.repo.Repository




class MainViewModelFactory

    constructor(private val app:Application,private val repository: Repository):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(app,repository) as T
    }

}