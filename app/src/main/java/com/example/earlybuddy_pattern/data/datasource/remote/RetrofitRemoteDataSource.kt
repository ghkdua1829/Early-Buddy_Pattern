package com.example.earlybuddy_pattern.data.datasource.remote

import com.example.earlybuddy_pattern.data.model.UserResponse
import com.google.gson.JsonObject
import retrofit2.Response

interface RetrofitRemoteDataSource {
    fun signUp(
        body: JsonObject,
        onResponse: (Response<UserResponse>) -> Unit,
        onFailure: (Throwable) -> Unit
    )

}