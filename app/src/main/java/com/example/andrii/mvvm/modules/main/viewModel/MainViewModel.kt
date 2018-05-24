package com.example.andrii.mvvm.modules.main.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PagedList
import android.databinding.ObservableBoolean
import com.example.andrii.mvvm.modules.main.adapter.DiffUtilCallback
import com.example.andrii.mvvm.modules.main.adapter.ListAdapter
import com.example.andrii.mvvm.modules.main.adapter.MainThreadExecutor
import com.example.andrii.mvvm.modules.main.adapter.MyPositionalDataSource
import com.example.andrii.mvvm.modules.main.repo.Repository
import java.util.concurrent.Executors

class MainViewModel(app:Application, private val repository: Repository) : AndroidViewModel(app) {

    init {
        repository.setViewModel(this)
    }

    val isLoading:ObservableBoolean = ObservableBoolean(false)
    val adapter:MutableLiveData<ListAdapter> = MutableLiveData()

    fun onSearchClicked(query:String){
        repository.setQuery(query)
        val dataSource = MyPositionalDataSource(repository)
        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(30)
                .build()
        val pagedList = PagedList.Builder(dataSource,config)
                .setMainThreadExecutor(MainThreadExecutor())
                .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
                .build()

        val listAdapter = ListAdapter(DiffUtilCallback())
        listAdapter.setList(pagedList)

        adapter.value = listAdapter
    }

    fun setLoading(loading:Boolean){
        isLoading.set(loading)
    }

}