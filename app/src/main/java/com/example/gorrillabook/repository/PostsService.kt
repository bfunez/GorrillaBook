package com.example.gorrillabook.repository

import com.example.gorrillabook.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostsService {
    @GET("feed")
    fun getFeed(): Call<ArrayList<Post>>
}