package com.example.gonggoose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.gonggoose.navigation.NavGraph
import com.example.gonggoose.ui.screen.HomeScreen
import com.example.gonggoose.ui.screen.auth.LoginScreen
import com.example.gonggoose.ui.screen.auth.SplashScreen
import com.example.gonggoose.ui.screen.chat.ChatMessageScreen
import com.example.gonggoose.ui.screen.chat.ChatRoomScreen
import com.example.gonggoose.ui.theme.GongGooseTheme
import com.kakao.sdk.common.util.Utility

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GongGooseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .statusBarsPadding()
                        .navigationBarsPadding()
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //실제 실행 코드
                    val navController = rememberNavController()
                    NavGraph(navController = navController)

//                    var keyHash = Utility.getKeyHash(this)
//                    Log.i("GlobalApplication", "$keyHash")

                    //테스트 코드 작성

                }
            }
        }
    }
}