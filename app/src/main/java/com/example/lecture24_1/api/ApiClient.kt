package com.example.lecture24_1.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.plugins.RxJavaPlugins
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private lateinit var myRetrofit: Retrofit

    fun getRetrofit(): Retrofit{
        if(!this::myRetrofit.isInitialized){
            myRetrofit = Retrofit.Builder()
                .baseUrl("https://apolis-property-management.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
        return myRetrofit
    }

    val apiService: ApiService by lazy{
        getRetrofit()
        myRetrofit.create(ApiService::class.java)
    }
}