package com.example.apiexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiexample.API.APIInterface
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.example.apiexample.dataAPIItem
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val retrofitBuilder by lazy{
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(APIInterface::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getJsondata()
    }

    private fun getJsondata(){
        val jsondata = retrofitBuilder.getAPIData()
        jsondata.enqueue(object : Callback<List<dataAPIItem>?> {
            override fun onResponse(
                call: Call<List<dataAPIItem>?>,
                response: Response<List<dataAPIItem>?>
            ) {
                val responseReturn = response.body()!!
                //val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
                //recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                //recyclerView.adapter = RVAdapter(responseReturn)


                for (data in responseReturn){
                    Log.d("APISUCCESS","ID: " + data.id)
                    Log.d("APISUCCESS","Title: " + data.title)
                }


            }
            override fun onFailure(call: Call<List<dataAPIItem>?>, t: Throwable) {
                Log.d("APIFAIL","message" + t.message)
            }
        })

    }

}