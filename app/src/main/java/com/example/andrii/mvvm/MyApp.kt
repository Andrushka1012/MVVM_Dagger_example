package com.example.andrii.mvvm

import android.app.Application
import android.content.Context
import com.example.andrii.mvvm.di.component.AppComponent
import com.example.andrii.mvvm.di.component.DaggerAppComponent
import com.example.andrii.mvvm.di.module.AppModule

class MyApp:Application(){

    companion object {
        fun getMyApp(context: Context):MyApp {
            return context.applicationContext as MyApp
        }
    }

    private val component: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

    fun getAppComponent():AppComponent{
        return component
    }

}