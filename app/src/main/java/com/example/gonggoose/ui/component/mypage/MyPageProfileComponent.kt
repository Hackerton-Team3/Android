package com.example.gonggoose.ui.component.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gonggoose.ui.theme.GongGooseTheme
import com.example.gonggoose.ui.theme.RoyalBlue

@Composable
fun MyPageProfileComponent() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(420.dp)
            .background(
                color = RoyalBlue,
                shape = RoundedCornerShape(bottomEnd = 15.dp, bottomStart = 15.dp)
            )
    )

}

@Preview
@Composable
private fun Preview() {
    GongGooseTheme {
        MyPageProfileComponent()
    }
}