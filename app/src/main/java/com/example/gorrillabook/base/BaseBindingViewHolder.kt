package com.example.gorrillabook.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


abstract class BaseBindingViewHolder<T>(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindViewHolder(item: T, itemClickListener: ((T) -> Unit)?) {
        binding.root.isClickable = itemClickListener != null
        binding.root.setOnClickListener { itemClickListener?.invoke(item) }
        bind(item)
    }
    abstract fun bind(item: T)

}