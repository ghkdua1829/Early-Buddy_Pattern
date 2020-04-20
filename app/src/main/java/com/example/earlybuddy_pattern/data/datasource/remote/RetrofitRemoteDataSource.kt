package com.example.earlybuddy_pattern.data.datasource.remote

import com.example.earlybuddy_pattern.data.model.PlaceResponse
import com.example.earlybuddy_pattern.data.model.UserResponse
import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.Response

interface RetrofitRemoteDataSource {
//    fun signUp(
//        body: JsonObject,
//        onResponse: (Response<UserResponse>) -> Unit,
//        onFailure: (Throwable) -> Unit
//    )
    fun singUp(body: JsonObject):Observable<UserResponse>

    fun getAddress(search:String):Observable<PlaceResponse>

}