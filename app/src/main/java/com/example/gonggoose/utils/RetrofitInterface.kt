package com.example.gonggoose.utils

import com.example.gonggoose.data.CreatePostRequest
import com.example.gonggoose.data.CreatePostResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import com.example.gonggoose.data.ApiResponse
import com.example.gonggoose.data.SignUp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface RetrofitInterface {

    // 작성예시
    @POST("/users")
    fun signUp(@Body signUp : SignUp) : Call<ApiResponse>

    @Multipart
    @POST("/bulletins")
    fun createPost(
        @Part images: List<MultipartBody.Part>,
        @Part request: CreatePostRequest
    ): CreatePostResponse

    @GET("/users/{kakaoId}")
    fun confirmDuplicate(@Path("kakaoId") kakaoId: String) : Call<ApiResponse>
}