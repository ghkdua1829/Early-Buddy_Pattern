package com.example.earlybuddy_pattern.data.datasource.remote

import android.util.Log
import com.example.earlybuddy_pattern.EarlyBuddyServiceImpl
import com.example.earlybuddy_pattern.data.model.PlaceResponse
import com.example.earlybuddy_pattern.data.model.SignInUserResponse
import com.example.earlybuddy_pattern.data.model.SignUpUserResponse
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

    override fun singUp(body: JsonObject): Observable<SignUpUserResponse> {
        return api.postSignupUser(body).map { it }
    }

    override fun signIn(body: JsonObject): Observable<SignInUserResponse> {
        return api.postSigninUser(body).map { it }
    }

}