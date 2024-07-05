package com.example.gonggoose.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.gonggoose.navigation.LocalNavGraphViewModelStoreOwner
import com.example.gonggoose.ui.component.detailPost.DetailPostBottomBar
import com.example.gonggoose.ui.component.detailPost.DetailPostContent
import com.example.gonggoose.ui.component.detailPost.DetailPostTopBar
import com.example.gonggoose.ui.component.detailPost.DetailPostUserInfo
import com.example.gonggoose.ui.component.detailPost.DetailPostViewPager
import com.example.gonggoose.viewmodel.HomeViewModel

@Composable
fun DetailPostScreen(navController: NavController, postId : Long) {

    val viewModel: HomeViewModel =
        viewModel(viewModelStoreOwner = LocalNavGraphViewModelStoreOwner.current)

    viewModel.getDetailPost(postId)

    val pagerState = rememberPagerState {
        viewModel.detailPostInfo.component1().imageUrlList.size
    }

    Scaffold (
        topBar = { DetailPostTopBar() },
        bottomBar = { DetailPostBottomBar(navController) }
    ){
        contentPadding ->
        Column (
            modifier = Modifier.padding(contentPadding)
        ){
            Column {
                DetailPostViewPager(pagerState)
                DetailPostUserInfo()
                DetailPostContent()
            }
        }
    }
}