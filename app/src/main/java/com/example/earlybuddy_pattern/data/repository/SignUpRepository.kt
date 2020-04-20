package com.example.earlybuddy_pattern.data.repository

import com.example.earlybuddy_pattern.data.datasource.remote.RetrofitRemoteDataSource
import com.example.earlybuddy_pattern.data.datasource.remote.RetrofitRemoteDataSourceImpl
import com.google.gson.JsonObject

class SignUpRepository {
    val RetrofitRemoteDataSource: RetrofitRemoteDataSource = RetrofitRemoteDataSourceImpl()
//    fun signUp(
//        body: JsonObject,
//        success: (Response<UserResponse>) -> Unit,
//        fail: (Throwable) -> Unit
//    ) {
//        RetrofitRemoteDataSource.signUp(body, success, fail)
//    }

    fun signUp(body: JsonObject) = RetrofitRemoteDataSource.singUp(body)
}