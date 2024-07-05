package com.example.gonggoose.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.gonggoose.ui.component.home.BottomNavigationBar

@Composable
fun MyPageScreen(navController: NavController) {
    Scaffold (
        bottomBar = { BottomNavigationBar(navController) }
    ){
        Column(
            modifier = Modifier.padding(it)
        ) {

        }
    }
}