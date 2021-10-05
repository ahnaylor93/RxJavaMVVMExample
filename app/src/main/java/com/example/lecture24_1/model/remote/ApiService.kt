package com.example.lecture24_1.model.remote

import com.example.lecture24_1.model.remote.request.LoginRequest
import com.example.lecture24_1.model.remote.response.LoginResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers("Content-type: application/json")
    @POST("auth/login")
    fun login(
        @Body loginData: LoginRequest
    ): Observable<LoginResponse>
}