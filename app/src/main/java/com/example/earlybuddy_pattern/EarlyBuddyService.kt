package com.example.earlybuddy_pattern

import com.example.earlybuddy_pattern.data.model.PlaceResponse
import com.example.earlybuddy_pattern.data.model.SignInUserResponse
import com.example.earlybuddy_pattern.data.model.SignUpUserResponse
import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface EarlyBuddyService {
    @POST("/users/signup")
    fun postSignupUser(
        @Body() body: JsonObject
    ): Observable<SignUpUserResponse>

    @POST("/users/signin")
    fun postSigninUser(
        @Body() body: JsonObject
    ): Observable<SignInUserResponse>

    @GET("/searchAddress")
    fun getAdress(
        @Query("addr") addr: String
    ): Observable<PlaceResponse>
}