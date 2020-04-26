package com.example.gorrillabook.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.gorrillabook.R


@BindingAdapter("setVisible")
fun setVisible(view: View, visible: Boolean) {
    view.visibility = if(visible) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("imageURL")
fun setImageURL(view: ImageView, imageURL: String?){
    if(imageURL != null) {
        val options =
            RequestOptions().placeholder(R.drawable.ic_gorilla_logo).error(R.color.colorPrimaryDark).centerCrop()
        Glide.with(view.context)
            .setDefaultRequestOptions(options)
            .load(imageURL)
            .into(view)
    }else{
        view.setImageResource(R.color.colorPrimaryDark)
    }
}