package com.example.gonggoose.ui.screen.auth

import android.util.Log
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gonggoose.R
import com.example.gonggoose.navigation.Routes
import com.example.gonggoose.ui.component.InputTextFieldWithoutSubText
import com.example.gonggoose.ui.theme.LivingCoral
import com.example.gonggoose.ui.theme.RoyalBlue
import com.example.gonggoose.utils.auth.kakaoLogin
import com.univcert.api.UnivCert
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun SchoolVerificationScreen(navController: NavController) {

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
        var schoolName by rememberSaveable { mutableStateOf("") }
        var schoolEmail by rememberSaveable { mutableStateOf("") }
        var code by rememberSaveable { mutableStateOf("") }

        var isSended by remember { mutableStateOf(false) }
        var isVerified by remember { mutableStateOf(false) }

        Text(
            text = "학교를 알려주스주스",
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

        //학교 입력
        InputTextFieldWithoutSubText(
            paddingValues = PaddingValues(top = 50.dp),
            value = schoolName,
            onValueChange = { it ->
                schoolName = it
            },
            hint = "학교 이름을 입력하세요",
            selectedColor = RoyalBlue
        )

        //학교 이메일 입력
        InputTextFieldWithoutSubText(
            paddingValues = PaddingValues(top = dimensionResource(id = R.dimen.padding_25)),
            value = schoolEmail,
            onValueChange = { it ->
                schoolEmail = it
            },
            hint = "학교 이메일을 입력하세요",
            selectedColor = RoyalBlue
        )

        //인증 코드 입력
        if (isSended) {
            InputTextFieldWithoutSubText(
                paddingValues = PaddingValues(top = dimensionResource(id = R.dimen.padding_25)),
                value = code,
                onValueChange = { it ->
                    code = it
                },
                hint = "인증 코드를 입력하세요",
                selectedColor = RoyalBlue
            )
        }

//        Text(
//            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_15)),
//            text = "정보를 다시 입력해주세요",
//            color = LivingCoral,
//            fontSize = 13.sp,
//            fontFamily = FontFamily(Font(R.font.noto_sans_kr_medium))
//        )

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
            onClick = {
                if (!isSended) {
                    // 인증번호 보내기 클릭 시
                    CoroutineScope(Dispatchers.Main).launch {
                        try {
                            // Dispatchers.IO를 사용하여 네트워크 작업을 비동기로 수행합니다.
                            withContext(Dispatchers.IO) {
                                UnivCert.certify(
                                    "99e32590-d026-4fa7-91bf-eeb445f39f78",
                                    schoolEmail,
                                    schoolName,
                                    true
                                )
                                UnivCert.status("99e32590-d026-4fa7-91bf-eeb445f39f78", schoolEmail)
                            }

                            // 인증 성공 시 처리
                            isSended = true // 인증 성공 여부 설정
                        } catch (e: Exception) {
                            // 예외 처리
                            Log.d("대학교 인증 실패", "정보가 잘못되었습니다.")
                        }
                    }

                } else if (!isVerified) {
                    // 인증코드 확인
                    CoroutineScope(Dispatchers.Main).launch {
                        try {
                            withContext(Dispatchers.IO) {
                                UnivCert.certifyCode(
                                    "99e32590-d026-4fa7-91bf-eeb445f39f78",
                                    schoolEmail,
                                    schoolName,
                                    code.toInt()
                                )
                            }

                            isVerified = true
                        } catch (e: Exception) {
                            e.printStackTrace()
                            Log.e("대학교 인증 실패", "정보가 잘못되었습니다.", e)
                        }
                    }

                } else {
                    // 시작하기
                    navController.navigate(Routes.Home.route)
                }
            }
        ) {
            Text(
                text = when {
                    isVerified -> "시작하기"
                    isSended -> "인증하기"
                    else -> "인증번호 보내기"
                },
                color = Color.White,
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_bold))
            )
        }


    }

}

enum class UnivCert {
    SENDCODE,
    VERIFYCODE,
    SUCCESS
}