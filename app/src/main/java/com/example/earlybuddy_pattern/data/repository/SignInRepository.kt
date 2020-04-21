package com.example.earlybuddy_pattern.data.repository

import com.example.earlybuddy_pattern.data.datasource.remote.RetrofitRemoteDataSourceImpl
import com.google.gson.JsonObject

class SignInRepository {

    val RetrofitRemoteDataSource = RetrofitRemoteDataSourceImpl()

    fun signIn(body: JsonObject) = RetrofitRemoteDataSource.signIn(body)
}