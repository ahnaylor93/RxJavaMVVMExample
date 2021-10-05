package com.example.lecture24_1.repository

import com.example.lecture24_1.model.remote.ApiClient
import com.example.lecture24_1.model.remote.request.LoginRequest
import com.example.lecture24_1.model.remote.response.LoginResponse
import io.reactivex.Observable

class NetworkData {
    fun retrieveData(loginRequest: LoginRequest): Observable<LoginResponse>{
        return ApiClient.apiService.login(loginRequest)
    }
}