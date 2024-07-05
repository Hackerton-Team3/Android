package com.example.gonggoose.ui.component.detailPost

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gonggoose.R
import com.example.gonggoose.navigation.LocalNavGraphViewModelStoreOwner
import com.example.gonggoose.ui.theme.GongGooseTheme
import com.example.gonggoose.ui.theme.MediumGray
import com.example.gonggoose.ui.theme.Orange
import com.example.gonggoose.ui.theme.White
import com.example.gonggoose.viewmodel.HomeViewModel

@Composable
fun DetailPostTopBar() {

    val viewModel: HomeViewModel =
        viewModel(viewModelStoreOwner = LocalNavGraphViewModelStoreOwner.current)

    val detailPostInfo = viewModel.detailPostInfo
    val color = if(detailPostInfo.component1().tag.equals("진행 중")) Orange else MediumGray

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .background(color),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
            modifier = Modifier
                .padding(start = 30.dp)
                .background(
                    color = White,
                    shape = RoundedCornerShape(16.dp)
                )
                .width(53.dp)
                .height(24.dp)
        ) {
            Text(
                text = detailPostInfo.component1().tag,
                color = color,
                fontSize = 11.sp,
                //fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Text(
            text = detailPostInfo.component1().title,
            fontSize = 15.sp,
            //fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
            modifier = Modifier
                .width(260.dp)
                .padding(start = 20.dp),
            maxLines = 1
        )
        
        Spacer(modifier = Modifier.weight(1f))

        Icon(
            painter = painterResource(id = R.drawable.btn_menu),
            contentDescription = "수정하기 버튼 아이콘",
            tint = White,
            modifier = Modifier.padding(start = 17.dp, end = 20.dp)
        )
    }
}

@Preview
@Composable
private fun Preview() {
    GongGooseTheme {
        DetailPostTopBar()
    }
}