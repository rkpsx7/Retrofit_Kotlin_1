package com.example.retrofit_kotlin_1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("comments")
    fun getPosts(@Query("postId") postId: Int): Call<List<ResponseItem>>
}