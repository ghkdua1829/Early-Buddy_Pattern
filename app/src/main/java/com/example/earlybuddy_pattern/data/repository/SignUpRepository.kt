package com.example.earlybuddy_pattern.data.repository

import com.example.earlybuddy_pattern.data.datasource.remote.RetrofitRemoteDataSource
import com.example.earlybuddy_pattern.data.datasource.remote.RetrofitRemoteDataSourceImpl
import com.example.earlybuddy_pattern.data.model.UserResponse
import com.google.gson.JsonObject
import retrofit2.Response

class SignUpRepository {
    val RetrofitRemoteDataSource: RetrofitRemoteDataSource = RetrofitRemoteDataSourceImpl()
    fun signUp(
        body: JsonObject,
        success: (Response<UserResponse>) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        RetrofitRemoteDataSource.signUp(body, success, fail)
    }
}