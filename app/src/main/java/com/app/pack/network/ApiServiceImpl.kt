package com.app.pack.network

import com.app.pack.model.Post
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService: ApiService) {

    suspend fun getPost() : List<Post> = apiService.getPosts()

}