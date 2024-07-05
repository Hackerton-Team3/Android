package com.example.gonggoose.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.gonggoose.R
import com.example.gonggoose.navigation.Routes
import com.example.gonggoose.ui.theme.DarkGray
import com.example.gonggoose.ui.theme.PaleGray
import com.example.gonggoose.ui.theme.RoyalBlue

@Composable
fun ChatMessage(message: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 12.dp),
        verticalAlignment = Alignment.Top
    ) {
//        AsyncImage(
//            modifier = Modifier
//                .size(30.dp)
//                .clip(CircleShape)
//                .border(1.dp, DarkGray, CircleShape),
//            model = "drawable/ic_goose_30",
//            contentDescription = "프로필 사진"
//        )

        Image(
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
                .border(1.dp, DarkGray, CircleShape),
            painter = painterResource(id = R.drawable.ic_goose_30),
            contentDescription = "프로필 사진"
        )

        Row(
            modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.btn_inner_padding_vertical_8),
                    end = 12.dp
                ),
            verticalAlignment = Alignment.Bottom
        ) {

            Box(
                modifier = Modifier
                    .background(PaleGray, shape = RoundedCornerShape(10.dp))
                    .padding(
                        horizontal = dimensionResource(id = R.dimen.btn_inner_padding_horizontal_10),
                        vertical = dimensionResource(id = R.dimen.btn_inner_padding_vertical_8)
                    )

            ) {
                Text(
                    text = message,
                    fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
                    fontSize = 13.sp,
                    color = Color.Black,
                    style = TextStyle(lineHeight = TextUnit.Unspecified)
                )
            }

            Text(
                modifier = Modifier
                    .padding(start = 8.dp),
                text = "10:00", //TODO : 시간 설정
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
                fontSize = 11.sp,
                color = DarkGray,
                style = TextStyle(lineHeight = TextUnit.Unspecified)
            )

        }
    }
}

@Composable
fun ChatMessageSelf(message: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.End
    ) {


        Row(
            modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.btn_inner_padding_vertical_8),
                    end = 8.dp
                ),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End
        ) {

            Text(
                modifier = Modifier
                    .padding(end = 8.dp),
                text = "10:00", //TODO : 시간 설정
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
                fontSize = 11.sp,
                color = DarkGray,
                style = TextStyle(lineHeight = TextUnit.Unspecified)
            )

            Box(
                modifier = Modifier
                    .background(RoyalBlue, shape = RoundedCornerShape(10.dp))
                    .padding(
                        horizontal = dimensionResource(id = R.dimen.btn_inner_padding_horizontal_10),
                        vertical = dimensionResource(id = R.dimen.btn_inner_padding_vertical_8)
                    )

            ) {
                Text(
                    text = message,
                    fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
                    fontSize = 13.sp,
                    color = Color.White,
                    style = TextStyle(lineHeight = TextUnit.Unspecified)
                )
            }

        }

        //        AsyncImage(
//            modifier = Modifier
//                .size(30.dp)
//                .clip(CircleShape)
//                .border(1.dp, DarkGray, CircleShape),
//            model = "drawable/ic_goose_30",
//            contentDescription = "프로필 사진"
//        )

        Image(
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
                .border(1.dp, DarkGray, CircleShape),
            painter = painterResource(id = R.drawable.ic_goose_30),
            contentDescription = "프로필 사진"
        )
    }
}

@Composable
fun ChatRoom(message: String, navController: NavController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {navController.navigate(Routes.ChatMessage.route) },
        verticalAlignment = Alignment.CenterVertically
    ) {
//        AsyncImage(
//            modifier = Modifier
//                .size(30.dp)
//                .clip(CircleShape)
//                .border(1.dp, DarkGray, CircleShape),
//            model = "drawable/ic_goose_30",
//            contentDescription = "채팅방 대표 사진"
//        )

        Image(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(15.dp))
                .border(1.dp, DarkGray, RoundedCornerShape(15.dp)),
            painter = painterResource(id = R.drawable.ic_goose_50),
            contentDescription = "채팅방 대표 사진"
        )

        Column(
            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.btn_inner_padding_horizontal_10)),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "공구스구스구스구스구스", //TODO : 공구 제목
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_medium)),
                fontSize = 15.sp,
                color = Color.Black,
                style = TextStyle(lineHeight = TextUnit.Unspecified)
            )

            Text(
                modifier = Modifier
                    .padding(top = 4.dp),
                text = "야호야호야호야호야호야호호야호야호야호야호야호호야호야호야호야호야호호야호야호야호야호야호", //TODO : 최신 채팅
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_medium)),
                fontSize = 11.sp,
                color = DarkGray,
                maxLines = 1,
                style = TextStyle(
                    lineHeight = TextUnit.Unspecified
                ),
                overflow = TextOverflow.Ellipsis
            )

        }
    }
}