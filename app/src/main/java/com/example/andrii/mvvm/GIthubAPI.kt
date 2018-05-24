package com.example.andrii.mvvm

import com.example.andrii.mvvm.model.SearchUsers
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface GithubAPI{

    companion object {
        const val base_url = "https://api.github.com/"
    }

    @GET("/search/users?client_id=5720488d90cd333cdb6c&client_secret=156d96058524a4b068eb76a8ec32f4de2f57eecb")
    fun searchUser(@Query(value = "q",encoded = true) query:String, @Query("page") page:Long): Observable<SearchUsers>

}