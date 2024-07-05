package com.example.gonggoose.ui.component.mypage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.gonggoose.R
import com.example.gonggoose.navigation.LocalNavGraphViewModelStoreOwner
import com.example.gonggoose.ui.component.home.PostItemUi
import com.example.gonggoose.viewmodel.HomeViewModel

@Composable
fun MyPageParticipatedPostList(navController: NavController) {

    val scrollState = rememberLazyListState()
    val viewModel: HomeViewModel =
        viewModel(viewModelStoreOwner = LocalNavGraphViewModelStoreOwner.current)

    val userInfo = viewModel.userInfo

    Column (
        modifier = Modifier
            .padding(
                start = dimensionResource(id = R.dimen.screen_padding_horizontal_35),
                end = dimensionResource(id = R.dimen.screen_padding_horizontal_35),
                top = 30.dp
            )
    ){
        LazyColumn(
            state = scrollState,
            verticalArrangement = Arrangement.spacedBy(25.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            contentPadding = PaddingValues(40.dp)
        ) {
            itemsIndexed(userInfo.component1().participatedPostList){ index, item ->
                if(index == 0){
                    Text(
                        text = "내가 참여한 공구",
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                    )
                    PostItemUi(item, navController)
                }
                else PostItemUi(item, navController)
            }
        }
    }
}