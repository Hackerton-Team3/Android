package com.example.gonggoose.ui.component.detailPost

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gonggoose.R
import com.example.gonggoose.navigation.LocalNavGraphViewModelStoreOwner
import com.example.gonggoose.viewmodel.HomeViewModel

@Composable
fun DetailPostContent() {

    val viewModel: HomeViewModel =
        viewModel(viewModelStoreOwner = LocalNavGraphViewModelStoreOwner.current)
    val detailPostInfo = viewModel.detailPostInfo.component1()


    Column (
        modifier = Modifier
            .padding(
                horizontal = dimensionResource(id = R.dimen.screen_padding_horizontal_35),
                vertical = 25.dp
            )
    ){
        Text(
            text = "상세 내용입니다.",
            fontSize = 13.sp,
        )
        Text(
            text = "",
            fontSize = 13.sp,
        )
        Text(
            text = detailPostInfo.detailContent,
            fontSize = 13.sp,
        )
    }
}