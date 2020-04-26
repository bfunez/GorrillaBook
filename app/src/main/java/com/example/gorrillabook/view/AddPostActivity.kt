package com.example.gorrillabook.view

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.gorrillabook.R
import com.example.gorrillabook.databinding.ActivityPostBinding
import com.example.gorrillabook.viewmodel.AddViewModel


class AddPostActivity : AppCompatActivity() {

    lateinit var binding: ActivityPostBinding
    lateinit var viewModel : AddViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setTupDataBinding()
    }


    fun setTupDataBinding(){
        viewModel = ViewModelProviders.of(this).get(AddViewModel::class.java)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_post )
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setSupportActionBar(binding.toolbar)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val findMenuItems = menuInflater
        findMenuItems.inflate(R.menu.add_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add_post -> {
                if(viewModel.eventText.get().isNullOrEmpty()){
                    Toast.makeText(this, getString(R.string.must_add_text), Toast.LENGTH_LONG).show()
                }else{
                    val intent = intent
                    intent.putExtra("post", viewModel.eventText.get())
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }


}
