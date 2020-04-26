package com.example.gorrillabook.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gorrillabook.R
import com.example.gorrillabook.databinding.ActivityMainBinding
import com.example.gorrillabook.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel : PostViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setTupDataBinding()
    }

    fun setTupDataBinding(){
        viewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main )
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    fun setUpViews(){
        binding.postsList.layoutManager= LinearLayoutManager(this)
        binding.postsList.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }
}
