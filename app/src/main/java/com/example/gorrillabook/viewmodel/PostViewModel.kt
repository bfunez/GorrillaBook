package com.example.gorrillabook.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import java.text.SimpleDateFormat
import java.util.*

class PostViewModel : ViewModel() {


    lateinit var context: Context
    val date = getCurrentDate()

    fun getCurrentDate() : String{
        val sdf = SimpleDateFormat("EEEE, MMMM dd", Locale.US)
        return sdf.format(Date())
    }
}