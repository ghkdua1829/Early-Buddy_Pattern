package com.example.earlybuddy_pattern

import com.example.earlybuddy_pattern.data.model.UserResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface EarlyBuddyService {
    @POST("/users/signup")
    fun postSignupUser(
        @Body() body: JsonObject
    ): Call<UserResponse>
}