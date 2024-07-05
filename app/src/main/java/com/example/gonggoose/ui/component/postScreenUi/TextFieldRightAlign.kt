package com.example.gonggoose.ui.component.postScreenUi

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gonggoose.R
import com.example.gonggoose.ui.theme.Black
import com.example.gonggoose.ui.theme.DarkGray

@Composable
fun TextFieldRightAlign(total_member : MutableState<Int>, maxLength: Int, unit: String) {
    BasicTextField(
        value = total_member.value.toString(),
        enabled = true,
        onValueChange = {
            if (it.length <= maxLength) {
                if(it.isEmpty()){
                    total_member.value = 0
                }else{
                    total_member.value = it.toInt()
                }
            } else {

            }
        },
        textStyle = TextStyle(
            fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
            fontSize = 13.sp,
            color = Black,
            textAlign = TextAlign.End
        ),
        singleLine = true,
        decorationBox = { innerTextField ->
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically

                ) {

                    Spacer(modifier = Modifier.weight(1f))
                    Box {
                        innerTextField()
                    }
                    Text(
                        text = unit,
                        fontSize = 13.sp,
                        color = Black
                    )
                }
                Divider(
                    modifier = Modifier
                        .padding(top = 8.dp, start = 60.dp),
                    color = DarkGray
                    // TODO: 입력 시 색상 변경
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        )
    )
}