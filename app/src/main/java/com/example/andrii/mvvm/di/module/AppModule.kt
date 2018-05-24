package com.example.andrii.mvvm.di.module

import com.example.andrii.mvvm.GithubAPI
import com.example.andrii.mvvm.MyApp
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule constructor(private val app: MyApp){

    @Singleton
    @Provides
    fun provideAppContext():MyApp{
        return app
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(GithubAPI.base_url)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(okHttpClient)
                .build()
    }

    @Singleton
    @Provides
    fun provideConvertFactory():Converter.Factory{
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient():OkHttpClient{
        return OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .build()
    }

}