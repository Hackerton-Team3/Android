package com.example.gonggoose.ui.component.postScreenUi

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gonggoose.R
import com.example.gonggoose.ui.theme.SoftBlack
import com.example.gonggoose.ui.theme.White

@Composable
fun PostPictureComponent() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp)
            .padding(top = 30.dp)
            .background(
                color = SoftBlack,
                shape = RoundedCornerShape(15.dp)
            )
            .clickable {
                // 사진 입력받기 how?
            }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.camera_plus),
            contentDescription = "카메라 아이콘",
            modifier = Modifier
                .align(Alignment.Center),
            tint = White
        )
    }
}