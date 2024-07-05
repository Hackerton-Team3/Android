package com.example.gonggoose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.gonggoose.navigation.NavGraph
import com.example.gonggoose.ui.screen.auth.EnterNickNameScreen
import com.example.gonggoose.ui.screen.auth.LoginScreen
import com.example.gonggoose.ui.screen.auth.SchoolVerificationScreen
import com.example.gonggoose.ui.theme.GongGooseTheme

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
//                    val navController = rememberNavController()
//                    NavGraph(navController = navController)

                    //테스트 코드 작성
                    SchoolVerificationScreen()

                }
            }
        }
    }
}