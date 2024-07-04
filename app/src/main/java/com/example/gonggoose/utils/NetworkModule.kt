package com.example.gonggoose.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://aiku.asia" //연결할 서버의 주소


//retrofit 객체 생성
fun getRetrofit(): Retrofit {
    val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    return retrofit
}