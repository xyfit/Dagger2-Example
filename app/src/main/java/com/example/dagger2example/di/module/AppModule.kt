package com.example.dagger2example.di.module

import com.example.restapiexample.api.RetrofitService
import com.example.restapiexample.repository.MainRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideJsonGsonConvertor() : GsonConverterFactory = GsonConverterFactory.create()
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(provideJsonGsonConvertor())
        .build()
    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): RetrofitService {
        return retrofit.create(RetrofitService::class.java)
    }
    @Provides
    fun mainRepo(retrofitService: RetrofitService): MainRepository {
        return MainRepository(retrofitService)
    }
}