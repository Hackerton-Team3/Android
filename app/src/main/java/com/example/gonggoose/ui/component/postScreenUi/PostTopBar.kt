package com.example.gonggoose.ui.component.postScreenUi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gonggoose.ui.theme.MediumGray

@Composable
fun PostTopBar() {
    Column (
        modifier = Modifier.fillMaxWidth()
    ){
        Text(
            text =  "게시글 등록",
            fontSize = 18.sp,
            modifier = Modifier
                .padding(start = 30.dp, top = 20.dp, bottom = 20.dp)
        )
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(MediumGray)
        )
    }

}