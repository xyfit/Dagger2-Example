package com.example.restapiexample.repository

import com.example.dagger2example.api.NetworkState
import com.example.restapiexample.api.RetrofitService
import com.example.restapiexample.models.MovieModel
import javax.inject.Inject

class MainRepository @Inject constructor(private val retrofitService: RetrofitService) {
    suspend fun getAllMovies() : NetworkState<List<MovieModel>> {
        val response = retrofitService.getAllMovies()
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkState.Success(responseBody)
            } else {
                NetworkState.Error(response)
            }
        } else {
            NetworkState.Error(response)
        }
    }
}
