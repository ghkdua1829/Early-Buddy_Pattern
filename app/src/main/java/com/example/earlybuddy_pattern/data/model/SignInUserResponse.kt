package com.example.earlybuddy_pattern.data.model

data class SignInUserResponse(
    val success: Boolean,
    val data: SignInUser

)

data class SignInUser(
    val jwt: String,
    val userIdx: Int,
    val userName: String
)