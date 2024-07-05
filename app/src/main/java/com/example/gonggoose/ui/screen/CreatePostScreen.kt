package com.example.gonggoose.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.gonggoose.R
import com.example.gonggoose.navigation.LocalNavGraphViewModelStoreOwner
import com.example.gonggoose.ui.component.InputTextField
import com.example.gonggoose.ui.component.postScreenUi.PostBottomBar
import com.example.gonggoose.ui.component.postScreenUi.PostDateComponent
import com.example.gonggoose.ui.component.postScreenUi.PostInputField
import com.example.gonggoose.ui.component.postScreenUi.PostPictureComponent
import com.example.gonggoose.ui.component.postScreenUi.PostTimeComponent
import com.example.gonggoose.ui.component.postScreenUi.PostTopBar
import com.example.gonggoose.ui.component.postScreenUi.getInitialTime
import com.example.gonggoose.viewmodel.HomeViewModel
import java.util.Calendar

@Composable
fun CreatePostScreen(navController: NavController) {

    val viewModel: HomeViewModel =
        viewModel(viewModelStoreOwner = LocalNavGraphViewModelStoreOwner.current)

    var title by remember {
        mutableStateOf("")
    }

    val scrollState = rememberScrollState()

    var selectedDate by remember { mutableStateOf(Calendar.getInstance()) }
    var selectedTime by remember { mutableStateOf(getInitialTime()) }

    viewModel.createPostInfo.component1().deadline = viewModel.mergeDateTime(selectedDate,selectedTime)
//    Log.d("memememememememe", viewModel.createPostInfo.component1().deadline.toString())

    Scaffold (
        topBar = { PostTopBar() },
        bottomBar = { PostBottomBar(navController) }
    ){
        contentPadding ->
        Box (
            modifier = Modifier
                .padding(
                    contentPadding,
                ),
        ){
            Column (
                modifier = Modifier
                    .padding(
                        horizontal = dimensionResource(id = R.dimen.screen_padding_horizontal_35),
                        vertical = dimensionResource(id = R.dimen.screen_padding_horizontal_30)
                    )
                    .verticalScroll(scrollState),
//                horizontalAlignment = Alignment.CenterHorizontally
            ){

                PostDateComponent()         //날짜 입력
                PostTimeComponent()         //시간 입력
                Text(
                    text = "마감 시간을 입력하라구스",
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(bottom = 45.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Text(
                    text = "제목 입력",
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(bottom = 15.dp)
                )
                InputTextField(
                    value = title,
                    hint = "제목을 입력하세요",
                    maxLength = integerResource(id = R.integer.max_title_length),
                    characterCount = title.length,
                    onValueChange = {
                        title = it
                        viewModel.createPostInfo.component1().title = it
//                        Log.d("memememememememe", viewModel.createPostInfo.component1().title.toString())
                    }
                )

                PostPictureComponent()

                PostInputField()
            }
        }
    }
}