package com.example.gonggoose.ui.screen.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gonggoose.R
import com.example.gonggoose.ui.component.ChatMessage
import com.example.gonggoose.ui.component.ChatMessageSelf
import com.example.gonggoose.ui.component.ChatRoom
import com.example.gonggoose.ui.component.home.BottomNavigationBar
import com.example.gonggoose.ui.theme.DarkGray
import com.example.gonggoose.viewmodel.ChatViewModel

@Composable
fun ChatRoomScreen(viewModel: ChatViewModel = ChatViewModel(), navController : NavController) {

    val listState = rememberLazyListState()

    val roomLoading by viewModel.roomLoading.observeAsState(initial = true)
    val chatRooms by viewModel.chatRooms.observeAsState(initial = emptyList())

    Scaffold(
        topBar = { TopChatRoomBar() },
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(top = 30.dp)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                // 채팅룸 리스트
                if (roomLoading) {
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
                            .padding(horizontal = dimensionResource(id = R.dimen.screen_padding_horizontal_30)),
                        state = listState,
                        verticalArrangement = Arrangement.spacedBy(25.dp),
                    ) {
                        if (chatRooms.isNotEmpty()) {
                            items(chatRooms.size) { index ->
                                ChatRoom(chatRooms[index], navController)
                            }
                        }

                    }
                }


            }
        }
    }
}

@Composable
fun TopChatRoomBar() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
    ) {

        Text(
            modifier = Modifier
                .padding(vertical = 20.dp)
                .padding(start = 30.dp)
            ,
            text = "채팅",
            fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
            fontSize = 18.sp,
            style = TextStyle(lineHeight = TextUnit.Unspecified)
        )

        Divider(
            color = DarkGray
        )

    }
}