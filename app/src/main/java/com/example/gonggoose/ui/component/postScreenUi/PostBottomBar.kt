package com.example.gonggoose.ui.component.postScreenUi

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.gonggoose.R
import com.example.gonggoose.navigation.LocalNavGraphViewModelStoreOwner
import com.example.gonggoose.ui.theme.LightBlue
import com.example.gonggoose.ui.theme.MediumGray
import com.example.gonggoose.ui.theme.Orange
import com.example.gonggoose.ui.theme.White
import com.example.gonggoose.viewmodel.HomeViewModel

@Composable
fun PostBottomBar(navController: NavController) {

    val viewModel: HomeViewModel =
        viewModel(viewModelStoreOwner = LocalNavGraphViewModelStoreOwner.current)

    val createPostInfo by viewModel.createPostInfo

    var color by remember {
        mutableStateOf(MediumGray)
    }

    if (viewModel.isFillAllPostInfo()) color = LightBlue else color = MediumGray

    Box(
        modifier = Modifier
            .padding(
                horizontal = dimensionResource(id = R.dimen.screen_padding_horizontal_35),
                vertical = dimensionResource(id = R.dimen.screen_padding_horizontal_30)
            )
            .background(
                color = color,
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxWidth()
            .height(54.dp)
            .clickable {
                if (viewModel.isFillAllPostInfo()) {
                    color = LightBlue
                    viewModel.createPostRequestFun()
                    navController.navigate("Home")
                }
                else color = MediumGray
            }
    ) {
        Text(
            text = "등록하기",
            color = White,
            fontSize = 15.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}