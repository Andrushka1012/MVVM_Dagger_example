package com.example.andrii.mvvm.modules.main.view
import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.andrii.mvvm.MyApp
import com.example.andrii.mvvm.R
import com.example.andrii.mvvm.databinding.ActivityMainBinding
import com.example.andrii.mvvm.di.component.DaggerActivityComponent
import com.example.andrii.mvvm.di.module.ActivityModule
import com.example.andrii.mvvm.modules.main.adapter.ListAdapter
import com.example.andrii.mvvm.modules.main.viewModel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val component by lazy { DaggerActivityComponent.builder()
            .appComponent(MyApp.getMyApp(this).getAppComponent())
            .activityModule(ActivityModule(this))
            .build()
    }

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.viewModel = this.viewModel

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.adapter.observe(this,
                Observer<ListAdapter> { if (it != null) recyclerView.adapter = it })
    }
}
