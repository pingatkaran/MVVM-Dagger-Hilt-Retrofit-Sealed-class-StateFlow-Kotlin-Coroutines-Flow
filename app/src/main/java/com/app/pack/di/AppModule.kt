package com.app.pack.di

import com.app.pack.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //Use this anywhere in application


    @Provides
    fun providesUrl() = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun providesApiService(url : String) : ApiService =
        Retrofit.Builder().baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)


}