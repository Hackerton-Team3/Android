package com.example.gonggoose.utils

import com.example.gonggoose.GlobalApplication.Companion.mSharedPreferences
import com.example.gonggoose.data.SignUp

//accessToken
fun saveJwt(jwtToken: String) {
    val editor = mSharedPreferences.edit()
    editor.putString("jwt", jwtToken)

    editor.apply()
}

fun getJwt(): String? = mSharedPreferences.getString("jwt", null)

fun saveUserId(jwtToken: Long) {
    val editor = mSharedPreferences.edit()
    editor.putLong("jwt", jwtToken)
    editor.apply()
}

fun getUserId(): Long? = mSharedPreferences.getLong("jwt", 0)

fun saveKakaoId(kakaoId: String) {
    val editor = mSharedPreferences.edit()
    editor.putString("kakaoId", kakaoId)
    editor.apply()
}

fun getKakaoId(): String? = mSharedPreferences.getString("kakaoId", null)

fun saveNickname(nickname: String) {
    val editor = mSharedPreferences.edit()
    editor.putString("nickname", nickname)
    editor.apply()
}

fun saveSchoolName(schoolName: String) {
    val editor = mSharedPreferences.edit()
    editor.putString("schoolName", schoolName)
    editor.apply()
}

fun saveSchoolEmail(schoolEmail: String) {
    val editor = mSharedPreferences.edit()
    editor.putString("schoolEmail", schoolEmail)
    editor.apply()
}

fun getSignUp(): SignUp? {
    val kakaoId = mSharedPreferences.getString("kakaoId", null)
    val nickname = mSharedPreferences.getString("nickname", null)
    val imageUrl = mSharedPreferences.getString("imageUrl", null)
    val schoolName = mSharedPreferences.getString("schoolName", null)
    val schoolEmail = mSharedPreferences.getString("schoolEmail", null)

    return if (kakaoId != null && nickname != null && schoolName != null && schoolEmail != null) {
        SignUp(kakaoId, nickname, imageUrl, schoolName, schoolEmail)
    } else {
        null
    }
}