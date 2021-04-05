package com.app.pack.network

import com.app.pack.model.Post
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts() : List<Post>

}