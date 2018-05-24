package com.example.andrii.mvvm.modules.main.repo

import android.arch.paging.PageKeyedDataSource
import android.util.Log
import com.example.andrii.mvvm.GithubAPI
import com.example.andrii.mvvm.model.SearchUsers
import com.example.andrii.mvvm.model.User
import com.example.andrii.mvvm.modules.main.viewModel.MainViewModel
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class Repository @Inject constructor(private val githubAPI: GithubAPI){

    private lateinit var query: String
    private lateinit var viewModel: MainViewModel

    fun setQuery(query:String){
        this.query = query
    }

    fun setViewModel(viewModel: MainViewModel) {
        this.viewModel = viewModel
    }

    fun fetchInitial(callback: PageKeyedDataSource.LoadInitialCallback<Long, User>) {
        fetch(1).observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewModel.setLoading(true) }
                .doOnUnsubscribe{ viewModel.setLoading(false) }
                .subscribe({ it.items?.let { it1 -> callback.onResult(it1,null,1) } },
                        {Log.e("QWE","ERROR:",it)})
    }

    fun fetchAfter(page: Long, callback: PageKeyedDataSource.LoadCallback<Long, User>) {
        val nextPage = page + 1
        fetch(page).observeOn(AndroidSchedulers.mainThread())
                .subscribe({ it.items?.let { it1 -> callback.onResult(it1,nextPage) } },
                        {Log.e("QWE","ERROR:",it)})
    }

    private fun fetch(page: Long):Observable<SearchUsers>{
        return githubAPI.searchUser(query,page)
    }


}