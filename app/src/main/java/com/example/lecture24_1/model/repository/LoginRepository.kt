package com.example.lecture24_1.model.repository

import com.example.lecture24_1.model.remote.request.LoginRequest
import com.example.lecture24_1.model.remote.response.LoginResponse
import io.reactivex.Observable
import javax.inject.Inject


class LoginRepository @Inject constructor(val networkData: NetworkData){
    fun fetchDataFromNetwork(loginRequest: LoginRequest): Observable<LoginResponse>{
        return networkData.retrieveData(loginRequest)
    }
}