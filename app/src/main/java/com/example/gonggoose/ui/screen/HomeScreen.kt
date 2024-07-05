package com.example.gonggoose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
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
import androidx.navigation.NavController
import com.example.gonggoose.R
import com.example.gonggoose.navigation.LocalNavGraphViewModelStoreOwner
import com.example.gonggoose.ui.component.BottomNavigationBar
import com.example.gonggoose.ui.component.FloatingButton
import com.example.gonggoose.ui.component.PostItemUi
import com.example.gonggoose.ui.component.TopBar
import com.example.gonggoose.viewmodel.HomeViewModel

@Composable
fun HomeScreen(navController : NavController) {

    val scrollState = rememberLazyListState()
    val viewModel: HomeViewModel =
        viewModel(viewModelStoreOwner = LocalNavGraphViewModelStoreOwner.current)

    Scaffold (
        bottomBar = { BottomNavigationBar(navController) } ,
        floatingActionButton = { FloatingButton(navController) },
        topBar = { TopBar() }
    ){
        contentPadding ->

        if(viewModel.postList.size > 0){
            LazyColumn(
                modifier = Modifier
                    .padding(contentPadding),
                state = scrollState,
                verticalArrangement = Arrangement.spacedBy(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(40.dp)
            ) {
                items(viewModel.postList){
                    PostItemUi(it, navController)
                }
            }
        }
        else{
            Column (
                modifier = Modifier.padding(contentPadding).fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "게시글이 없다구스구스",
                    fontSize = 30.sp,
                    fontFamily = FontFamily(Font(R.font.bmjua))
                )
                Image(painter = painterResource(
                    id = R.drawable.char_goose_speak),
                    contentDescription = "거위",
                    modifier = Modifier
                        .width(300.dp)
                        .height(250.dp)
                        .padding(top = 20.dp)
                )
            }
        }
    }
}