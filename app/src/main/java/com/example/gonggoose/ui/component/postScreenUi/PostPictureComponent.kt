package com.example.gonggoose.ui.component.postScreenUi

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.gonggoose.R
import com.example.gonggoose.navigation.LocalNavGraphViewModelStoreOwner
import com.example.gonggoose.ui.theme.SoftBlack
import com.example.gonggoose.ui.theme.White
import com.example.gonggoose.viewmodel.HomeViewModel

@Composable
fun PostPictureComponent() {

    val viewModel: HomeViewModel =
        viewModel(viewModelStoreOwner = LocalNavGraphViewModelStoreOwner.current)

    var pictureImage by remember {
        mutableStateOf<List<Uri>>(emptyList())
    }

    var check by remember {
        mutableStateOf(false)
    }

    val galleryLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetMultipleContents()) { uri ->
        uri.let{
            pictureImage = it
            viewModel.uriList.clear() // 기존 리스트 클리어
            viewModel.uriList.addAll(it) // 선택한 URI들 추가
            check = true
        }
    }

    if(viewModel.uriList.isEmpty() && !check){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
                .padding(top = 30.dp)
                .background(
                    color = SoftBlack,
                    shape = RoundedCornerShape(15.dp)
                )
                .clickable {
                    // 사진 입력받기 how?
                    galleryLauncher.launch("image/*")
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.camera_plus),
                contentDescription = "카메라 아이콘",
                modifier = Modifier
                    .align(Alignment.Center),
                tint = White
            )
        }
    }
    else {
        if(viewModel.uriList.isNotEmpty()){
            AsyncImage(
                model = viewModel.uriList[0],
                contentDescription = "가장 첫 번째 이미지",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp)
                    .padding(top = 30.dp)
                    .background(
                        color = SoftBlack,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .clickable {
                        // 사진 입력받기 how?
                        galleryLauncher.launch("image/*")
                    }
            )
        }
    }
}