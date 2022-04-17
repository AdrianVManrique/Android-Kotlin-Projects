package com.example.apiexample.API

import com.example.apiexample.dataAPIItem
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("posts")
        fun getAPIData(): Call<List<dataAPIItem>>
}
