package com.example.gonggoose.utils

import com.example.gonggoose.data.CreatePostRequest
import com.example.gonggoose.data.CreatePostResponse
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import com.example.gonggoose.data.ApiResponse
import com.example.gonggoose.data.ApiResponse2
import com.example.gonggoose.data.ChatMessageResponse
import com.example.gonggoose.data.ChatRoomResponse
import com.example.gonggoose.data.SignUp
import com.example.gonggoose.data.UserChattingData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path


interface RetrofitInterface {

    @POST("/users")
    fun signUp(@Body signUp : SignUp) : Call<ApiResponse>

    @Multipart
    @POST("/bulletins")
    fun createPost(
        @Part images: List<MultipartBody.Part>,
        @Part request: CreatePostRequest
    ): CreatePostResponse

    @GET("/users/{kakaoId}")
    fun confirmDuplicate(@Path("kakaoId") kakaoId: String) : Call<ApiResponse2>

    @GET("/users/{userId}/chattingRooms")
    fun loadChatRooms(@Path("userId") userId: Long) : Call<ChatRoomResponse>

    @GET("/users/{userId}/chattingRooms/{chatRoomId}")
    fun loadChatMessages(@Path("userId") userId: Long, @Path("chatRoomId") chatRoomId: Long) : Call<ChatMessageResponse>

}