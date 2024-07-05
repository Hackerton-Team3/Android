package com.example.gonggoose.utils

import com.example.gonggoose.data.CreatePostRequest
import com.example.gonggoose.data.CreatePostResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface RetrofitInterface {

    // 작성예시
    /*
    @POST("/login/sign-in")
    fun getToken(@Body kakaoId : Long) : Call<Token>
    */

    @Multipart
    @POST("/bulletins")
    fun createPost(
        @Part images: List<MultipartBody.Part>,
        @Part request: CreatePostRequest
    ): CreatePostResponse

}