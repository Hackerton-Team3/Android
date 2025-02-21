package com.example.gonggoose.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://0f31-2001-2d8-f191-71af-1d65-d1be-8705-a728.ngrok-free.app" //연결할 서버의 주소
const val UNIV_URL = "https://api.univcert.com/"


//retrofit 객체 생성
fun getRetrofit(): Retrofit {
    val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    return retrofit
}

fun getUnivRetrofit(): Retrofit {
    return Retrofit.Builder().baseUrl(UNIV_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
}