package com.example.gonggoose.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.gonggoose.R
import com.example.gonggoose.navigation.LocalNavGraphViewModelStoreOwner
import com.example.gonggoose.ui.theme.SoftBlack
import com.example.gonggoose.ui.theme.White
import com.example.gonggoose.viewmodel.HomeViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailPostViewPager(pagerState: PagerState, ) {

    val viewModel: HomeViewModel =
        viewModel(viewModelStoreOwner = LocalNavGraphViewModelStoreOwner.current)


    if(viewModel.detailPostInfo.component1().imageUrlList.isEmpty()){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(SoftBlack)
        ){
            Text(
                text = "?",
                fontSize = 60.sp,
                fontFamily = FontFamily(Font(R.font.bmjua)),
                color = White,
                modifier = Modifier
                    .align(Alignment.Center)
            )
            Image(
                painter = painterResource(id = R.drawable.char_goose_main),
                contentDescription = "이미지 없을 때 이미지",
                modifier = Modifier
                    .width(150.dp)
                    .height(200.dp)
                    .align(Alignment.BottomEnd)
            )
        }
    }
    else{
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            GlideImage(
                model = viewModel.detailPostInfo.component1().imageUrlList.get(it),
                contentDescription = "등록된 공구 이미지"
            )
        }
    }
}