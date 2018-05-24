package com.example.andrii.mvvm.modules.main.adapter

import android.arch.paging.PageKeyedDataSource
import com.example.andrii.mvvm.model.User
import com.example.andrii.mvvm.modules.main.repo.Repository

class MyPositionalDataSource
    constructor(private val repository: Repository) : PageKeyedDataSource<Long,User>() {

    override fun loadInitial(params: LoadInitialParams<Long>, callback: LoadInitialCallback<Long, User>) {
        repository.fetchInitial(callback)
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, User>) {
        repository.fetchAfter(params.key,callback)
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, User>) {

    }


}