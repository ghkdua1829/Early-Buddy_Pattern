package com.example.earlybuddy_pattern.data.model

import com.google.gson.annotations.SerializedName

data class SignUpUserResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: Int
)