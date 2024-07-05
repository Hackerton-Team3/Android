package com.example.gonggoose.ui.component.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gonggoose.R
import com.example.gonggoose.data.ItemInfo
import com.example.gonggoose.navigation.Routes
import com.example.gonggoose.ui.theme.RoyalBlue
import com.example.gonggoose.ui.theme.White

@Composable
fun BottomNavigationBar(navController: NavController) {

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ){
        NavigationBar (
            containerColor = RoyalBlue,
            modifier = Modifier.padding(top = 40.dp)
        ){
            val backStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = backStackEntry?.destination?.route

            BottomNavigationBarItems.items.forEachIndexed(){
                    index, item ->
                NavigationBarItem(

//                    selected = currentRoute == item.route,
                    selected = false,

                    onClick = {
                        navController.navigate(item.route){
                            popUpTo(Routes.Home.route) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },

                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.name,
                            tint = White,
                            modifier = Modifier.size(28.dp)
                        )
                    },

                    label = {
                        Text(
                            text = item.name,
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.noto_sans_kr_regular)),
                            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_between_icon_and_text_vertical_2))
                        )
                    },
                )
            }
        }
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(White)
                .border(
                    width = 2.dp,
                    color = RoyalBlue,
                    shape = CircleShape
                )
                .size(80.dp)
                .align(Alignment.Center)
                .clickable {
                    navController.navigate("Home") {
                        launchSingleTop = true
                    }
                }
        )
        Image(
            painter = painterResource(id = R.drawable.ic_goose),
            contentDescription = "app icon",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(65.dp)
                .clip(CircleShape)
                .align(Alignment.Center)
                .clickable {
                    navController.navigate("Home") {
                        launchSingleTop = true
                    }
                }
                //.padding(5.dp)
        )
    }
}

object BottomNavigationBarItems{
    val items = listOf(
        ItemInfo(R.drawable.ic_chatting, "채팅", Routes.Chatting.route),
        ItemInfo(R.drawable.btm_nav_mypage, "마이 페이지", Routes.MyPage.route),
    )
}

