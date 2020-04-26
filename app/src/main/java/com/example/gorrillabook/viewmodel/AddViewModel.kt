package com.example.gorrillabook.viewmodel

import android.content.Context
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import java.text.SimpleDateFormat
import java.util.*

class AddViewModel : ViewModel() {

    lateinit var context: Context
    val isLoading = ObservableBoolean(true)
    val maxChars = ObservableInt(160)
    val eventText = ObservableField<String>("")
}