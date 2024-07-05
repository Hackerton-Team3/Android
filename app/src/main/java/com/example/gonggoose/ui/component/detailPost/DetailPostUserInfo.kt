package com.example.gonggoose.ui.component.detailPost

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.gonggoose.R
import com.example.gonggoose.navigation.LocalNavGraphViewModelStoreOwner
import com.example.gonggoose.ui.component.CustomRoundedBox
import com.example.gonggoose.ui.theme.MediumGray
import com.example.gonggoose.ui.theme.Orange
import com.example.gonggoose.ui.theme.White
import com.example.gonggoose.viewmodel.HomeViewModel
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailPostUserInfo() {

    val viewModel: HomeViewModel =
        viewModel(viewModelStoreOwner = LocalNavGraphViewModelStoreOwner.current)

    val detailPostInfo = viewModel.detailPostInfo.component1()
    val color = if(detailPostInfo.tag == "진행 중") Orange else MediumGray

    val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm")
    val formattedDateTime = detailPostInfo.deadline.format(formatter)

    Box(
        modifier = Modifier
            .padding(top = 25.dp, end = 100.dp)
//            .fillMaxWidth()
            .height(85.dp)
            .background(
                color = White,
                shape = RoundedCornerShape(topEnd = 15.dp, bottomEnd = 15.dp)
            )
            .border(3.dp, color, shape = RoundedCornerShape(topEnd = 15.dp, bottomEnd = 15.dp))

    ){
        Row (
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ){
            if(detailPostInfo.userImage == null){
                Image(
                    painter = painterResource(id = R.drawable.ic_goose),
                    contentDescription = "기본 이미지",
                    modifier = Modifier
                        .padding(start= 20.dp)
                        .size(60.dp)
                        .background(
                            color = White,
                            shape = CircleShape
                        )
                        .border(3.dp, color, shape = CircleShape)
                )
            }
            else{
                GlideImage(
                    model = detailPostInfo.userImage,
                    contentDescription = "유저 카카오 프로필 사진",
                    modifier = Modifier
                        .padding(start= 20.dp)
                        .size(60.dp)
                        .background(
                            color = White,
                            shape = CircleShape
                        )
                        .border(3.dp, color, shape = CircleShape)
                )
            }

            Column (
                modifier = Modifier.padding(start = 15.dp)
            ){
                Row {
                    Text(
                        text = detailPostInfo.title,
                        fontSize = 15.sp,
                        maxLines = 2,
                        modifier = Modifier
                            .width(280.dp)
                    )
                    CustomRoundedBox(
                        text = detailPostInfo.current_member.toString() + "/" + detailPostInfo.total_member.toString(),
                        modifier =  Modifier
                            .padding(start=8.dp)
                            .background(
                                color = if(detailPostInfo.tag.equals("진행 중")) Orange else MediumGray,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .width(53.dp)
                            .height(24.dp)
                    )
                }
                Text(
                    text = formattedDateTime.toString(),
                    color = MediumGray
                )
            }
        }

    }

}