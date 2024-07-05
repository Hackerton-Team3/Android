package com.example.gonggoose.ui.component.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gonggoose.R
import com.example.gonggoose.ui.theme.Orange

@Composable
fun FloatingButton(navController: NavController) {
    FloatingActionButton(
        onClick = { navController.navigate("CreatePost") },
        shape = CircleShape,
        containerColor = Orange,
        modifier = Modifier.padding(end = 10.dp)
    ) {
        Icon(painter = painterResource(id = R.drawable.btn_plus) , contentDescription = "")
    }
}