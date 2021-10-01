package com.example.lecture24_1.repository

import com.example.lecture24_1.api.request.LoginRequest
import com.example.lecture24_1.api.response.LoginResponse
import io.reactivex.Observable

class LoginRepository {
    fun fetchDataFromNetwork(loginRequest: LoginRequest): Observable<LoginResponse>{
        return NetworkData().retrieveData(loginRequest)
    }
}