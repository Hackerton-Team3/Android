package com.example.gonggoose.ui.component.detailPost

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gonggoose.R
import com.example.gonggoose.ui.theme.MediumGray
import com.example.gonggoose.ui.theme.SoftBlack
import com.example.gonggoose.ui.theme.White

@Composable
fun DetailPostBottomBar(navController: NavController) {
    Box(
        modifier = Modifier
            .height(75.dp)
            .fillMaxWidth()
    ){
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(MediumGray)
        )

        Box(
            modifier = Modifier
                .padding(
                    horizontal = dimensionResource(id = R.dimen.screen_padding_horizontal_35),
                    vertical = dimensionResource(id = R.dimen.btn_inner_padding_horizontal_10)
                )
                .fillMaxWidth()
                .height(54.dp)
                .background(
                    color = SoftBlack,
                    shape = RoundedCornerShape(16.dp)
                )
                .align(Alignment.Center)
        ){
            Icon(
                painter = painterResource(id = R.drawable.ic_chatting),
                contentDescription = "채팅 아이콘",
                modifier = Modifier
                    .padding(start = 20.dp, top = 13.dp)
                    .size(28.dp),
                tint = White
            )

            Text(
                text = "채팅 참여하기",
                fontSize = 15.sp,
                color = White,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}