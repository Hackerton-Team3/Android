package com.example.gonggoose

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.gonggoose.utils.XAccessTokenInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonElement
import com.kakao.sdk.common.KakaoSdk
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okhttp3.logging.HttpLoggingInterceptor
import okio.ByteString
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit

class GlobalApplication : Application() {

    companion object {
        const val X_ACCESS_TOKEN: String = "Authorization"         // JWT Token Key
        const val TAG: String = "TEMPLATE-APP"                      // Log, SharedPreference
        const val APP_DATABASE = "$TAG-DB"

        const val DEV_URL: String = "https://0f31-2001-2d8-f191-71af-1d65-d1be-8705-a728.ngrok-free.app"     // 테스트 서버 주소
        const val PROD_URL: String = "https://aiku.asia"   // 실서버 주소
        const val BASE_URL: String = DEV_URL

        lateinit var mSharedPreferences: SharedPreferences
        lateinit var retrofit: Retrofit
        lateinit var webSocket: WebSocket
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

//        // Gson 인스턴스 생성 시 설정 변경
//        val gson: Gson = GsonBuilder()
//            .setLenient() // 유연한 모드 설정
//            .registerTypeAdapter(Long::class.java, { json: JsonElement, typeOfT: Type, context: JsonDeserializationContext -> json.asString.toLong() })
//            .create()

        //레트로핏
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // WebSocket
//        val request = Request.Builder().url("wss://3a88-2001-2d8-f191-71af-1d65-d1be-8705-a728.ngrok-free.app").build()
//        val listener = MyWebSocketListener()
//        webSocket = client.newWebSocket(request, listener)

        //sharedPreference
        mSharedPreferences = applicationContext.getSharedPreferences(TAG, Context.MODE_PRIVATE)


    }
}

class MyWebSocketListener : WebSocketListener() {
    override fun onOpen(webSocket: WebSocket, response: Response) {
        super.onOpen(webSocket, response)
        Log.d("WebSocket", "WebSocket Connected")
        webSocket.send("Hello, World!")
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        super.onMessage(webSocket, text)
        Log.d("WebSocket", "Received message: $text")
    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
        super.onMessage(webSocket, bytes)
        Log.d("WebSocket", "Received bytes: $bytes")
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        super.onClosing(webSocket, code, reason)
        Log.d("WebSocket", "Closing: $code / $reason")
        webSocket.close(1000, null)
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        super.onFailure(webSocket, t, response)
        Log.e("WebSocket", "Error: " + t.message)
    }
}


