package com.example.restapiexample.models

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("title")
    val name: String,
    val imageUrl: String,
    @SerializedName("body")
    val desc: String
    )