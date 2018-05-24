package com.example.andrii.mvvm.modules.main.adapter

import android.support.v7.recyclerview.extensions.DiffCallback
import com.example.andrii.mvvm.model.User



class DiffUtilCallback : DiffCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id === newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.login.equals(newItem.login) && oldItem.avatar_url == newItem.avatar_url
    }

}