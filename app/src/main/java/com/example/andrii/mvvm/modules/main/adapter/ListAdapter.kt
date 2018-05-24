package com.example.andrii.mvvm.modules.main.adapter

import android.arch.paging.PagedListAdapter
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.andrii.mvvm.R
import com.example.andrii.mvvm.databinding.ItemUserBinding
import com.example.andrii.mvvm.model.User

class ListAdapter
    constructor(callback:DiffUtilCallback):PagedListAdapter<User,ViewHolder>(callback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding:ItemUserBinding = DataBindingUtil.inflate(inflater, R.layout.item_user,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class ViewHolder constructor(private val binding:ItemUserBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(user:User?){
        binding.user = user
        binding.executePendingBindings()
    }
}