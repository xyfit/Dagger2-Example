package com.example.restapiexample.api

import com.example.restapiexample.models.MovieModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface RetrofitService {

    @GET("posts")
    suspend fun getAllMovies() : Response<List<MovieModel>>

}