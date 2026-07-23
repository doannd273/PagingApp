package com.example.paggingapp.data.remote

import com.example.paggingapp.data.model.PostDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("posts")
    suspend fun getPosts(
        @Query("_page") page: Int,
        @Query("_limit") limit: Int
    ): List<PostDto>

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }
}