package com.example.gorrillabook.repository

interface PostsService {
    @GET("/2.0/?method=artist.search")
    fun searchArtist(@Query("artist") artist: String): Call

}