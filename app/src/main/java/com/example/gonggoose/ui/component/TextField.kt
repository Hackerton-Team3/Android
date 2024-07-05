package com.example.gonggoose.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gonggoose.R
import com.example.gonggoose.ui.theme.DarkGray

@Composable
fun InputTextField(
    paddingValues: PaddingValues = PaddingValues(0.dp), //양옆 패딩 (피그마 : 보통 35dp)
    value : String, //입력된 텍스트
    hint : String, //힌트
    maxLength : Int, //최대 글자 수
    characterCount : Int, //글자 수
    onValueChange: (String) -> Unit,
    enabled : Boolean = true
) {
    BasicTextField(
        modifier = Modifier
            .padding(paddingValues),
        value = value,
        enabled = enabled,
        onValueChange = {
            if (it.length <= maxLength) {
                onValueChange(it)
            } else {

            }
        },
        textStyle = TextStyle(
            fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
            fontSize = 13.sp,
            color = Color.Black
        ),
        singleLine = true,
        decorationBox = { innerTextField ->
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically

                ) {

                    Box {
                        if (value.isEmpty()) {
                            Text(
                                text = "$hint",
                                fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
                                fontSize = 13.sp,
                                color = DarkGray,
                                style = TextStyle(lineHeight = TextUnit.Unspecified)
                            )
                        }
                        innerTextField()
                    }

                    Spacer(modifier = Modifier.weight(1f))


                    Text(
                        text = "$characterCount/$maxLength",
                        fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
                        fontSize = 11.sp,
                        color = DarkGray
                    )
                }

                Divider(
                    modifier = Modifier.padding(top = 8.dp),
                    color = DarkGray
                    // TODO: 입력 시 색상 변경
                )

                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = "최대 ${maxLength}자 입력이 가능합니다",
                    fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
                    fontSize = 11.sp,
                    color = Color.Black,
                    style = TextStyle(lineHeight = TextUnit.Unspecified)
                )

            }
        }
    )
}