package com.example.andrii.mvvm.di.component

import com.example.andrii.mvvm.di.module.ActivityModule
import com.example.andrii.mvvm.di.scope.ActivityScope
import com.example.andrii.mvvm.modules.main.view.MainActivity
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class],
            dependencies = [AppComponent::class])
interface ActivityComponent{
    fun inject(activity:MainActivity)
}