package com.example.gonggoose.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.gonggoose.ui.theme.White

@Composable
fun CustomRoundedBox(text: String, modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        Text(
            text = text,
            color = White,
            fontSize = 11.sp,
            //fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}