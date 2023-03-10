package com.example.restapiexample.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetManager {
    var retrofitService: RetrofitService? = null
    fun getInstance() : RetrofitService {
        if (retrofitService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofitService = retrofit.create(RetrofitService::class.java)
        }
        return retrofitService!!
    }
}