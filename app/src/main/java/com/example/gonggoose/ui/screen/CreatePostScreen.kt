package com.example.gonggoose.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavController
import com.example.gonggoose.R
import com.example.gonggoose.ui.component.postScreenUi.PostBottomBar
import com.example.gonggoose.ui.component.postScreenUi.PostDateComponent
import com.example.gonggoose.ui.component.postScreenUi.PostTopBar

@Composable
fun CreatePostScreen(navController: NavController) {
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
            ){
                PostDateComponent()
            }
        }
    }
}