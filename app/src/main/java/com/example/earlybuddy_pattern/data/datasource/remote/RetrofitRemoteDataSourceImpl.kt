package com.example.earlybuddy_pattern.data.datasource.remote

import android.util.Log
import com.example.earlybuddy_pattern.EarlyBuddyServiceImpl
import com.example.earlybuddy_pattern.data.model.PlaceResponse
import com.example.earlybuddy_pattern.data.model.UserResponse
import com.google.gson.JsonObject
import io.reactivex.Observable

class RetrofitRemoteDataSourceImpl : RetrofitRemoteDataSource {
    val api = EarlyBuddyServiceImpl.service
    override fun getAddress(search: String): Observable<PlaceResponse> =
        api.getAdress(search)
            .doOnError {
                Log.e("gu, ':!!!!!", "s")
                it.printStackTrace() }
            .map { it }

    override fun singUp(body: JsonObject): Observable<UserResponse> {
        return api.postSignupUser(body).map { it }
    }

//    override fun signUp(
//        body: JsonObject,
//        onResponse: (Response<UserResponse>) -> Unit,
//        onFailure: (Throwable) -> Unit
//    ) {
//        EarlyBuddyServiceImpl.service.postSignupUser(body)
//            .enqueue(object : retrofit2.Callback<UserResponse> {
//                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
//                    onFailure(t)
//                }
//
//                override fun onResponse(
//                    call: Call<UserResponse>,
//                    response: Response<UserResponse>
//                ) {
//                    onResponse(response)
//                }
//            })
//    }
}