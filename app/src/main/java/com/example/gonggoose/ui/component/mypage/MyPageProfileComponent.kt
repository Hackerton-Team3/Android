package com.example.gonggoose.ui.component.mypage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.gonggoose.R
import com.example.gonggoose.navigation.LocalNavGraphViewModelStoreOwner
import com.example.gonggoose.ui.theme.GongGooseTheme
import com.example.gonggoose.ui.theme.Orange
import com.example.gonggoose.ui.theme.RoyalBlue
import com.example.gonggoose.ui.theme.White
import com.example.gonggoose.viewmodel.HomeViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MyPageProfileComponent() {

    val viewModel: HomeViewModel =
        viewModel(viewModelStoreOwner = LocalNavGraphViewModelStoreOwner.current)

    val userInfo = viewModel.userInfo

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(470.dp)
            .background(
                color = RoyalBlue,
                shape = RoundedCornerShape(bottomEnd = 60.dp, bottomStart = 60.dp)
            )
    ){
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
        ){
            Box(
                modifier = Modifier
                    .size(250.dp)
                    .background(
                        color = Orange,
                        shape = CircleShape
                    )
                    .align(Alignment.Center)
            )

            if(userInfo.component1().imageUrl == null){
                Box(
                    modifier = Modifier
                        .size(230.dp)
                        .background(
                            color = White,
                            shape = CircleShape
                        )
                        .border(10.dp, RoyalBlue, CircleShape)
                        .align(Alignment.Center)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_goose),
                    contentDescription = "오리 이미지",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(170.dp)
                        .align(Alignment.Center)
                        .padding(top = 15.dp)
                )
            }
            else{
                GlideImage(
                    model = userInfo.component1().imageUrl,
                    contentDescription = "유저 프로필 사진",
                    modifier = Modifier
                        .size(230.dp)
                        .background(
                            color = White,
                            shape = CircleShape
                        )
                        .border(10.dp, RoyalBlue, CircleShape)
                        .align(Alignment.Center)
                )
            }


            Text(
                text = userInfo.component1().university,
                fontSize = 20.sp,
                color = White,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 330.dp)
            )
            Text(
                text = userInfo.component1().userName,
                fontSize = 18.sp,
                color = White,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 400.dp)
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    GongGooseTheme {
        MyPageProfileComponent()
    }
}