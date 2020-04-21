package com.example.earlybuddy_pattern.data.datasource.remote

import com.example.earlybuddy_pattern.data.model.PlaceResponse
import com.example.earlybuddy_pattern.data.model.SignInUserResponse
import com.example.earlybuddy_pattern.data.model.SignUpUserResponse
import com.google.gson.JsonObject
import io.reactivex.Observable

interface RetrofitRemoteDataSource {

    fun singUp(body: JsonObject): Observable<SignUpUserResponse>

    fun getAddress(search:String):Observable<PlaceResponse>

    fun signIn(body: JsonObject): Observable<SignInUserResponse>

}