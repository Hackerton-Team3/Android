package com.example.gonggoose.ui.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gonggoose.R
import com.example.gonggoose.ui.component.shadow
import com.example.gonggoose.ui.theme.DarkGray
import com.example.gonggoose.ui.theme.KakaoBlack
import com.example.gonggoose.ui.theme.KakaoYellow
import com.example.gonggoose.ui.theme.MediumGray
import com.example.gonggoose.ui.theme.RoyalBlue
import com.example.gonggoose.utils.auth.kakaoLogin
import com.example.gonggoose.utils.auth.kakaoTalkLogin

@Composable
fun LoginScreen(navController : NavController) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RoyalBlue),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Column(
            modifier = Modifier.weight(0.45f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                modifier = Modifier.padding(bottom = 15.dp),
                text = "로그인 하라구스~",
                fontFamily = FontFamily(Font(R.font.bmjua)),
                fontSize = 30.sp,
                color = Color.White
            )

            Image(
                modifier = Modifier
                    .size(303.dp, 197.43.dp),
                painter = painterResource(id = R.drawable.char_goose_okay),
                contentDescription = "대표 캐릭터"
            )
        }


        Column(
            modifier = Modifier
                .weight(0.55f)
                .fillMaxWidth()
                .background(Color.White)
                .padding(top = 50.dp, bottom = 40.dp)
                .padding(horizontal = dimensionResource(id = R.dimen.screen_padding_horizontal_35)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {

                Button(
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = KakaoYellow,
                        disabledContainerColor = KakaoYellow
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(
                            color = MediumGray,
                            borderRadius = 8.dp,
                            offsetY = 5.dp,
                            spread = 1.dp,
                            blurRadius = 8.dp
                        )
                    ,
                    content = {
                        Text(
                            text = "카카오톡으로 간편로그인",
                            color = KakaoBlack,
                            fontSize = 15.sp,
                            fontFamily = FontFamily(Font(R.font.noto_sans_kr_bold))
                        )
                    },
                    contentPadding = PaddingValues(
                        top = 4.dp,
                        bottom = 4.dp,
                    ),
                    onClick = { kakaoTalkLogin(context) },
                )

                Image(
                    modifier = Modifier.padding(start = 27.dp),
                    painter = painterResource(id = R.drawable.ic_kakao_message_circle),
                    contentDescription = "카카오톡 아이콘"
                )
            }

            Button(
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = KakaoYellow,
                    disabledContainerColor = KakaoYellow
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.padding_15))
                    .shadow(
                        color = MediumGray,
                        borderRadius = 8.dp,
                        offsetY = 5.dp,
                        spread = 1.dp,
                        blurRadius = 8.dp
                    ),
                contentPadding = PaddingValues(
                    top = 4.dp,
                    bottom = 4.dp,
                ),
                content = {
                    Text(
                        text = "카카오 계정으로 로그인",
                        color = KakaoBlack,
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.noto_sans_kr_bold))
                    )
                },
                onClick = { kakaoLogin(context, navController) },
            )


            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Copyright © 2024, 공구스. All rights reserved.",
                color = Color.Black,
                fontSize = 11.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular))
            )


        }

    }
}