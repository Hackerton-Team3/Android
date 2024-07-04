package com.example.gonggoose.utils

import com.example.gonggoose.GlobalApplication.Companion.mSharedPreferences

//accessToken
fun saveJwt(jwtToken: String) {
    val editor = mSharedPreferences.edit()
    editor.putString("jwt", jwtToken)

    editor.apply()
}

fun getJwt(): String? = mSharedPreferences.getString("jwt", null)