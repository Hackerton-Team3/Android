package com.example.gonggoose.ui.screen.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gonggoose.R
import com.example.gonggoose.ui.component.ChatMessage
import com.example.gonggoose.ui.component.ChatMessageSelf
import com.example.gonggoose.ui.theme.DarkGray
import com.example.gonggoose.viewmodel.ChatViewModel

@Composable
fun ChatMessageScreen(viewModel: ChatViewModel = ChatViewModel()) {

    val listState = rememberLazyListState()

    val messageLoading by viewModel.messageLoading.observeAsState(initial = true)
    val chatMessages by viewModel.chatMessages.observeAsState(initial = emptyList())
    var message by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // 채팅 메시지 리스트
        if (messageLoading) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }

        } else {
            // 데이터 로딩 완료 후 채팅 메시지 리스트 표시
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = dimensionResource(id = R.dimen.screen_padding_horizontal_25)),
                state = listState,
                verticalArrangement = Arrangement.spacedBy(15.dp),
            ) {
                if (chatMessages.isNotEmpty()) {
                    items(chatMessages.size) { index ->
                        ChatMessageSelf(message = chatMessages[index])
                        ChatMessage(message = chatMessages[index])

                        //TODO : 날짜가 변경되면 띄우기
//                        Text(
//                            text = "2024년 7월 5일 금요일",
//                            fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
//                            fontSize = 11.sp,
//                            color = DarkGray,
//                            style = TextStyle(lineHeight = TextUnit.Unspecified)
//                        )

                    }
                }

            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = dimensionResource(id = R.dimen.screen_padding_horizontal_20),
                    vertical = dimensionResource(id = R.dimen.btn_inner_padding_vertical_4)
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = message,
                onValueChange = {
                    message = it
                },
                shape = RoundedCornerShape(15.dp),
                placeholder = {
                    Text(
                        text = "메시지를 입력하세요",
                        fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
                        fontSize = 13.sp,
                        color = DarkGray,
                        style = TextStyle(lineHeight = TextUnit.Unspecified)
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.DarkGray, // 포커스 시 테두리 색상
                    unfocusedBorderColor = Color.DarkGray, // 포커스 해제 시 테두리 색상
                    cursorColor = Color.Black, // 커서 색상
                ),
                textStyle = TextStyle(
                    color = Color.Black, // 입력된 텍스트 색상 설정
                    fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
                    fontSize = 13.sp
                )
            )

            Image(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(27.dp)
                    .clickable(onClick = { }),
                painter = painterResource(id = R.drawable.btn_send),
                contentDescription = "전송버튼"
            )
        }
    }
}