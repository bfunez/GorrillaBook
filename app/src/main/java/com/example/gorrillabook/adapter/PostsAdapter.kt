package com.example.gorrillabook.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.gorrillabook.R
import com.example.gorrillabook.base.BaseBindingAdapter
import com.example.gorrillabook.base.BaseBindingViewHolder
import com.example.gorrillabook.databinding.ItemLayoutBinding


import com.example.gorrillabook.model.Post

class PostsAdapter (private val items: List<Post>):
    BaseBindingAdapter<PostsAdapter.PostViewHolder, Post>(items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_layout,
                parent, false))
    }

    override fun getItemCount() = items.size


    class PostViewHolder(val binding: ItemLayoutBinding) : BaseBindingViewHolder<Post>(binding) {
        override fun bind(item: Post) {
            binding.item = item
        }
    }
}