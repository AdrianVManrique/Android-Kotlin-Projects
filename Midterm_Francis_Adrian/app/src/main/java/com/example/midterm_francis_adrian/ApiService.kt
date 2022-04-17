package com.example.midterm_francis_adrian

import android.telecom.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    fun getPosts(): retrofit2.Call<MutableList<PostModel>>
}