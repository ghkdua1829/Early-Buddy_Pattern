package com.example.earlybuddy_pattern.data.datasource.remote

import com.example.earlybuddy_pattern.EarlyBuddyServiceImpl
import com.example.earlybuddy_pattern.data.model.UserResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response

class RetrofitRemoteDataSourceImpl : RetrofitRemoteDataSource {
    override fun signUp(
        body: JsonObject,
        onResponse: (Response<UserResponse>) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        EarlyBuddyServiceImpl.service.postSignupUser(body)
            .enqueue(object : retrofit2.Callback<UserResponse> {
                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    onFailure(t)
                }

                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    onResponse(response)
                }
            })
    }
}