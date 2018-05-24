package com.example.andrii.mvvm.modules.main.adapter

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor


class MainThreadExecutor:Executor{

    private val handler:Handler = Handler(Looper.getMainLooper())

    override fun execute(p0: Runnable?) {
        handler.post(p0)
    }
}