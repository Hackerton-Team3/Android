package com.example.gonggoose.data

import com.google.gson.annotations.SerializedName

data class SignUp(
    @SerializedName("kakaoId") val kakaoId: String,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("imageUrl") val imageUrl: String? = null,
    @SerializedName("schoolName") val schoolName: String,
    @SerializedName("schoolEmail") val schoolEmail: String
)

data class ApiResponse(
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: Result
)

data class Result(
    @SerializedName("userId") val userId: Long
)