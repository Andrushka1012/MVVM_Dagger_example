package com.example.andrii.mvvm.di.module

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import com.example.andrii.mvvm.GithubAPI
import com.example.andrii.mvvm.MyApp
import com.example.andrii.mvvm.di.scope.ActivityScope
import com.example.andrii.mvvm.modules.main.repo.Repository
import com.example.andrii.mvvm.modules.main.viewModel.MainViewModel
import com.example.andrii.mvvm.modules.main.viewModel.MainViewModelFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ActivityModule constructor(private val context: AppCompatActivity){

    @ActivityScope
    @Provides
    fun provideViewModel(context: AppCompatActivity,
                         factory: MainViewModelFactory): MainViewModel {
        return ViewModelProviders.of(context,factory).get(MainViewModel::class.java)
    }

    @ActivityScope
    @Provides
    fun provideActivityContext():AppCompatActivity{
        return context
    }

    @ActivityScope
    @Provides
    fun provideModelFactory(app:MyApp,repository: Repository): MainViewModelFactory{
        return MainViewModelFactory(app,repository)
    }

    @ActivityScope
    @Provides
    fun provideApiClient(retrofit: Retrofit):GithubAPI{
        return retrofit.create(GithubAPI::class.java)
    }


}