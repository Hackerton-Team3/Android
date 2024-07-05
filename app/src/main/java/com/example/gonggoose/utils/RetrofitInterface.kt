package com.example.gonggoose.utils

import com.example.gonggoose.data.ApiResponse
import com.example.gonggoose.data.SignUp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface RetrofitInterface {

    @POST("/users")
    fun signUp(@Body signUp : SignUp) : Call<ApiResponse>

    @GET("/users/{kakaoId}")
    fun confirmDuplicate(@Path("kakaoId") kakaoId: String) : Call<ApiResponse>

    @("/websocket")
    fun confirmDuplicate(@Path("kakaoId") kakaoId: String) : Call<ApiResponse>
}