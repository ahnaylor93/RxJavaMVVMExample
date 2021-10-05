package com.example.lecture24_1.model.repository

import com.example.lecture24_1.model.remote.request.LoginRequest
import com.example.lecture24_1.model.remote.response.LoginResponse
import io.reactivex.Observable

class LoginRepository {
    fun fetchDataFromNetwork(loginRequest: LoginRequest): Observable<LoginResponse>{
        return NetworkData().retrieveData(loginRequest)
    }
}