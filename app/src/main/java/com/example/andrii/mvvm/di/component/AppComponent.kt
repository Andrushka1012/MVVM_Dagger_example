package com.example.andrii.mvvm.di.component

import com.example.andrii.mvvm.MyApp
import com.example.andrii.mvvm.di.module.AppModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent{
    fun exposeRetrofit(): Retrofit

    fun provideApp():MyApp

    fun inject(app: MyApp)
}