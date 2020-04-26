package com.example.gorrillabook.viewmodel

import android.content.Context
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gorrillabook.model.Post
import com.example.gorrillabook.view.MainActivity
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class PostViewModel : ViewModel() {


    lateinit var context: Context
    val isLoading = ObservableBoolean(true)
    val date = getCurrentDate()
    var  adapterdata : ArrayList<Post> = arrayListOf()
    lateinit var viewActions: MainActivity.ViewActions

    fun getCurrentDate() : String{
        val sdf = SimpleDateFormat("EEEE, MMMM dd", Locale.US)
        return sdf.format(Date())
    }
}