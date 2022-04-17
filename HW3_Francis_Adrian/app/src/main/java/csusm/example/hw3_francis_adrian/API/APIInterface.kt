package csusm.example.hw3_francis_adrian.API

import csusm.example.hw3_francis_adrian.DataAPIItem
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("posts")
    fun getAPIData(): Call<List<DataAPIItem>>
}