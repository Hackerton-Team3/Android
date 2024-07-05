package com.example.gonggoose.ui.component.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gonggoose.R
import com.example.gonggoose.ui.theme.MediumGray

@Composable
fun TopBar() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "건국대학교 서울캠퍼스",
                fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(start = 25.dp)
            )
            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(
                    id = R.drawable.ic_search
                ),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 150.dp, end = 20.dp)
                    .size(28.dp)
            )
        }
    }
}