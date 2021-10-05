package com.example.lecture24_1.model.remote.response

data class LoginResponse(
    val token: String?,
    val user: User?,
    val error: Boolean?,
    val message: String?
)

data class User(
    val __v: Int,
    val _id: String,
    val createdAt: String,
    val email: String,
    val type: String,
    val name: String
)
