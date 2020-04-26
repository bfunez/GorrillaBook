package com.example.gorrillabook.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseBindingAdapter<T : BaseBindingViewHolder<E>, E>(private val items: List<E>) :
    RecyclerView.Adapter<T>() {

    protected var itemClickListener: ((E) -> Unit)? = null

    fun setOnItemClickListner(listener: (E) -> Unit) {
        itemClickListener = listener
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindViewHolder(items[position], itemClickListener)
    }
}