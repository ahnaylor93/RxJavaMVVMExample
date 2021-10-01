package com.example.lecture24_1.repository

import com.example.lecture24_1.api.ApiClient
import com.example.lecture24_1.api.request.LoginRequest
import com.example.lecture24_1.api.response.LoginResponse
import io.reactivex.Observable

class NetworkData {
    fun retrieveData(loginRequest: LoginRequest): Observable<LoginResponse>{
        return ApiClient.apiService.login(loginRequest)
    }
}