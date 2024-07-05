package com.example.gonggoose.ui.component.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.gonggoose.R
import com.example.gonggoose.data.PostItem
import com.example.gonggoose.navigation.Routes
import com.example.gonggoose.ui.component.CustomRoundedBox
import com.example.gonggoose.ui.theme.MediumGray
import com.example.gonggoose.ui.theme.Orange
import com.example.gonggoose.ui.theme.White

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PostItemUi(postItem: PostItem, navController: NavController) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { navController.navigate(Routes.DetailPost.route + "?postid=${postItem.postId}") }
    ){
        if(postItem.imageUrl != null){
            GlideImage(
                model = postItem.imageUrl,
                contentDescription = "공구사진",
                modifier = Modifier
                    .size(80.dp)
                    .background(
                        color= White,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .border(1.dp, MediumGray,RoundedCornerShape(15.dp))
            )
        }else{
            Image(
                painter = painterResource(id = R.drawable.ic_goose),
                contentDescription = "기본 이미지",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .background(
                        color= White,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .border(1.dp, MediumGray,RoundedCornerShape(15.dp))
            )
        }

        Column (
            //verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(start = 5.dp)
        ){
            CustomRoundedBox(
                postItem.tag,
                modifier = Modifier
                    .padding(start=15.dp)
                    .background(
                        color = if(postItem.tag.equals("진행 중")) Orange else MediumGray,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .width(53.dp)
                    .height(24.dp)
            )
            Text(
                text = postItem.title,
                fontSize = 15.sp,
                //fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
                modifier = Modifier.padding(top =4.dp, bottom = 4.dp, start= 15.dp)
            )
            Text(
                text = postItem.current_member.toString() + "/" + postItem.total_member.toString(),
                fontSize = 11.sp,
                //fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
                color = MediumGray,
                modifier = Modifier.padding(start= 15.dp)
            )
        }
    }
}