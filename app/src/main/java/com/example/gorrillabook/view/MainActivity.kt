package com.example.gorrillabook.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gorrillabook.R
import com.example.gorrillabook.adapter.PostsAdapter
import com.example.gorrillabook.databinding.ActivityMainBinding
import com.example.gorrillabook.model.Post
import com.example.gorrillabook.repository.PostsService
import com.example.gorrillabook.viewmodel.PostViewModel
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    companion object{
        const val add_event_request = 1
    }

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel : PostViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setTupDataBinding()
    }

    override fun onResume() {
        super.onResume()
        if(viewModel.adapterdata.isNullOrEmpty()) {
            getInitialData()
        }
    }

    fun setTupDataBinding(){
        viewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        viewModel.viewActions = viewActions
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main )
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setSupportActionBar(binding.toolbar)
        binding.toolbar.title =null

    }



    fun getInitialData() {
        val request = ServiceBuilder.buildService(PostsService::class.java)
        val call = request.getFeed()

        call.enqueue(object : Callback<ArrayList<Post>> {
            override fun onResponse(call: Call<ArrayList<Post>>, response: Response<ArrayList<Post>>) {
                if (response.isSuccessful){
                    binding.postsList.apply {
                        setHasFixedSize(true)
                        viewModel.isLoading.set(false)

                        layoutManager = LinearLayoutManager(this@MainActivity)
                        response.body()?.let {
                            viewModel.adapterdata = it
                        }
                        binding.postsList.adapter = PostsAdapter(viewModel.adapterdata)
                        println("set data")
                    }
                }
            }
            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }


    object ServiceBuilder {
        private val client = OkHttpClient.Builder().build()

        private val retrofit = Retrofit.Builder()
            .baseUrl("https://gl-endpoint.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        fun<T> buildService(service: Class<T>): T{
            return retrofit.create(service)
        }
    }

    val viewActions = object : ViewActions {
        override fun newPost() {
            val intent = Intent( this@MainActivity, AddPostActivity::class.java)
            startActivityForResult(intent, add_event_request)
        }
    }

    interface ViewActions{
        fun newPost()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == add_event_request && resultCode == Activity.RESULT_OK){
            data?.let {
                if(data.hasExtra("post")){
                    viewModel.adapterdata.add(0,
                        Post(Random.nextInt(50, 100), "Brayan",
                            "Funez", data.getStringExtra("post")!!, System.currentTimeMillis(), null)
                    )
                    println("added event")
                    binding.postsList.adapter?.notifyDataSetChanged()
                }
            }
        }
    }
}
