package com.example.gonggoose

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.gonggoose.utils.XAccessTokenInterceptor
import com.kakao.sdk.common.KakaoSdk
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class GlobalApplication : Application() {

    companion object {
        const val X_ACCESS_TOKEN: String = "Authorization"         // JWT Token Key
        const val TAG: String = "TEMPLATE-APP"                      // Log, SharedPreference
        const val APP_DATABASE = "$TAG-DB"

        const val DEV_URL: String = "https://aiku.asia"     // 테스트 서버 주소
        const val PROD_URL: String = "https://aiku.asia"   // 실서버 주소
        const val BASE_URL: String = DEV_URL

        lateinit var mSharedPreferences: SharedPreferences
        lateinit var retrofit: Retrofit
    }

    override fun onCreate() {
        super.onCreate()

        // Kakao SDK 초기화
        KakaoSdk.init(this, getString(R.string.native_app_key))

        /*var keyHash = Utility.getKeyHash(this)
        Log.i("GlobalApplication", "$keyHash")*/

        // Create a logging interceptor
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        //api
        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(100, TimeUnit.SECONDS)
            .connectTimeout(100, TimeUnit.SECONDS)
            .writeTimeout(100, TimeUnit.SECONDS) // 쓰기 타임아웃 설정
            .addInterceptor(XAccessTokenInterceptor()) // JWT 자동 헤더 전송
            .addInterceptor(logging)
            .build()

        //레트로핏
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        //sharedPreference
        mSharedPreferences = applicationContext.getSharedPreferences(TAG, Context.MODE_PRIVATE)


    }
}


