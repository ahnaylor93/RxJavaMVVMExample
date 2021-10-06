package com.example.lecture24_1.model.repository

import com.example.lecture24_1.datainjection.component.DaggerApplicationComponent
import com.example.lecture24_1.datainjection.module.ApplicationModule
import com.example.lecture24_1.model.remote.ApiService
import com.example.lecture24_1.model.remote.request.LoginRequest
import com.example.lecture24_1.model.remote.response.LoginResponse
import io.reactivex.Observable
import javax.inject.Inject



class NetworkData @Inject constructor(){
    @Inject
    lateinit var apiService: ApiService

    init{
        val daggerApplicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule()).build()

        daggerApplicationComponent.inject(this)
    }

    fun retrieveData(loginRequest: LoginRequest): Observable<LoginResponse>{
        return apiService.login(loginRequest)
    }
}