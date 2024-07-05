package com.example.gonggoose.ui.component.postScreenUi

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gonggoose.R
import com.example.gonggoose.ui.theme.DarkGray

@SuppressLint("UnrememberedMutableState")
@Composable
fun PostInputField() {
    var total_member by remember {
        mutableIntStateOf(0)
    }
    var predicted_price by remember {
        mutableIntStateOf(0)
    }
    var content by remember {
        mutableStateOf("")
    }

    Column {
        Row (
            modifier = Modifier
                .padding(top = 31.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "모집 인원",
                fontSize = 15.sp
            )
            TextFieldRightAlign(
                mutableIntStateOf(total_member),
                5,
                "명"
            )
        }
        Row (
            modifier = Modifier
                .padding(top = 31.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "예상 가격",
                fontSize = 15.sp
            )
            TextFieldRightAlign(
                mutableIntStateOf(predicted_price),
                6,
                "원"
            )
        }

        Text(
            text = "내용 입력",
            fontSize = 15.sp,
            modifier = Modifier
                .padding(top =25.dp)
        )
        Divider(
            modifier = Modifier
                .padding(top = 8.dp),
            color = DarkGray
            // TODO: 입력 시 색상 변경
        )
        BasicTextField(
            value = content,
            onValueChange = {
                if(it.length <= 200){
                    content = it
                }
            },
            decorationBox = {innerTextField ->
                if(content.isEmpty()){
                    Text(
                        text = "내용을 입력하세요",
                        fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
                        fontSize = 13.sp,
                        color = DarkGray,
                        style = TextStyle(lineHeight = TextUnit.Unspecified)
                    )
                }
                innerTextField()
            },
            modifier = Modifier.padding(top = 8.dp),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            )
        )
    }
}