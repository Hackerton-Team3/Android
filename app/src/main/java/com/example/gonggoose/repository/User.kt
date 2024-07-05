package com.example.gonggoose.repository

import android.util.Log
import androidx.navigation.NavController
import com.example.gonggoose.data.ApiResponse
import com.example.gonggoose.data.ApiResponse2
import com.example.gonggoose.data.SignUp
import com.example.gonggoose.navigation.Routes
import com.example.gonggoose.utils.RetrofitInterface
import com.example.gonggoose.utils.getKakaoId
import com.example.gonggoose.utils.getRetrofit
import com.example.gonggoose.utils.getSignUp
import com.example.gonggoose.utils.saveUserId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun signUp(signUp: SignUp, navController: NavController) {
    val retrofitInterface = getRetrofit().create(RetrofitInterface::class.java)
    retrofitInterface.signUp(signUp)
        .enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                Log.d("API - 회원가입", "onResponse: ${response.code()}")
                if (response.isSuccessful) {
                    val resp = response.body()
                    if (resp != null) {
                        if (resp != null) {
                            saveUserId(resp.result.userId)
                        }
                    }
                    navController.navigate(Routes.Home.route)
                } else {
                    Log.e("API - 회원가입", "Response 실패: ${response.errorBody()?.string()}")

                }
            }
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("API - 회원가입", "onFailure", t)
            }
        })
}

fun confirmDuplicate(navController: NavController) {
    val retrofitInterface = getRetrofit().create(RetrofitInterface::class.java)
    getKakaoId()?.let {
        retrofitInterface.confirmDuplicate(it)
        .enqueue(object : Callback<ApiResponse2> {
            override fun onResponse(call: Call<ApiResponse2>, response: Response<ApiResponse2>) {
                Log.d("API - 유저 유무 조회", "onResponse: ${response.code()}")
                if (response.isSuccessful) {
                    val resp = response.body()
                    if (resp != null) {
                        if (resp != null) {
                            saveUserId(resp.result)
                        }
                    }
                    navController.navigate(Routes.Home.route)
                } else {
                    Log.e("API - 유저 유무 조회", "Response 실패: ${response.errorBody()?.string()}")
                    navController.navigate(Routes.EnterNickName.route)
                }
            }
            override fun onFailure(call: Call<ApiResponse2>, t: Throwable) {
                Log.e("API - 유저 유무 조회", "onFailure", t)
            }
        })
    }

}