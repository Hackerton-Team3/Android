package com.example.gonggoose.ui.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gonggoose.R
import com.example.gonggoose.ui.component.InputTextField
import com.example.gonggoose.ui.theme.KakaoBlack
import com.example.gonggoose.ui.theme.KakaoYellow
import com.example.gonggoose.ui.theme.RoyalBlue
import com.example.gonggoose.utils.auth.kakaoLogin

@Composable
fun EnterNickNameScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = dimensionResource(id = R.dimen.screen_padding_horizontal_35))
            .padding(
                top = 80.dp,
                bottom = dimensionResource(id = R.dimen.screen_padding_bottom_30)
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //state
        var nickName by rememberSaveable { mutableStateOf("") }
        var characterCount by rememberSaveable { mutableStateOf(nickName.length) }

        Text(
            text = "닉네임을 알려주스주스",
            color = Color.Black,
            fontSize = 30.sp,
            fontFamily = FontFamily(Font(R.font.bmjua))
        )

        Image(
            modifier = Modifier
                .padding(top = 15.dp)
                .size(width = 300.dp, height = 250.dp),
            painter = painterResource(id = R.drawable.char_goose_speak),
            contentDescription = "공구스 캐릭터"
        )

        //닉네임 입력
        InputTextField(
            paddingValues = PaddingValues(top = 50.dp),
            maxLength = integerResource(id = R.integer.max_nickName_length),
            value = nickName,
            characterCount = characterCount,
            onValueChange = { it ->
                nickName = it
                characterCount = it.length
            },
            hint = "닉네임을 입력하세요"
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = RoyalBlue,
                disabledContainerColor = RoyalBlue
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = RoyalBlue, shape = RoundedCornerShape(15.dp)),
            contentPadding = PaddingValues(
                top = 4.dp,
                bottom = 4.dp,
            ),
            content = {
                Text(
                    text = "다음",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.noto_sans_kr_bold))
                )
            },
            onClick = {
                //TODO : 네비게이션 연결
            },
        )


    }

}