package com.example.gonggoose.viewmodel

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.gonggoose.data.CreatePostInfo
import com.example.gonggoose.data.CreatePostRequest
import com.example.gonggoose.data.DetailPostInfo
import com.example.gonggoose.data.PostItem
import com.example.gonggoose.data.UserInfo
import com.example.gonggoose.utils.getUserId
import com.example.gonggoose.utils.network.Repository
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Calendar

class HomeViewModel : ViewModel() {

    val repository = Repository()

    var postList = mutableListOf<PostItem>(
        PostItem(1,null,"진행 중","청심대에서 건구스랑 놀 사람",3,10),
        PostItem(1,null,"마감","청심대에서 건구스랑 놀 사람",3,10),
        PostItem(1,null,"진행 중","청심대에서 건구스랑 놀 사람",3,10),
        PostItem(1,null,"진행 중","청심대에서 건구스랑 놀 사람",3,10),
        PostItem(1,null,"진행 중","청심대에서 건구스랑 놀 사람",3,10),
        PostItem(1,null,"진행 중","청심대에서 건구스랑 놀 사람",3,10),
        PostItem(1,null,"진행 중","청심대에서 건구스랑 놀 사람",3,10),
        PostItem(1,null,"진행 중","청심대에서 건구스랑 놀 사람",3,10),
        PostItem(1,null,"진행 중","청심대에서 건구스랑 놀 사람",3,10),
        PostItem(1,null,"진행 중","청심대에서 건구스랑 놀 사람",3,10),
    )

    var createPostInfo = mutableStateOf<CreatePostInfo>(
        CreatePostInfo(null,null,null,null,null)
    )

    var detailPostInfo = mutableStateOf<DetailPostInfo>(
        DetailPostInfo(listOf(), "진행 중", "청심대에서 건구스랑 놀 사람 아ㅓㄹ아ㅓㄹ;머라;마ㅣㅓ람ㅇ러ㅏㅓ모라ㅣ머ㅗㄹㅁㄹ", 7, 100, LocalDateTime.of(2024,7,5, 17,0), null, "건구스구스", "건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ ")
    )

    var userInfo = mutableStateOf<UserInfo>(
        UserInfo(1,null, "건국대학교 서울캠퍼스", "건구스구스", listOf(
            PostItem(1,null,"진행 중","청심대에서 건구스랑 놀 사람",3,10),
            PostItem(1,null,"마감","청심대에서 건구스랑 놀 사람",3,10),
            PostItem(1,null,"진행 중","청심대에서 건구스랑 놀 사람",3,10),
            PostItem(1,null,"마감","청심대에서 건구스랑 놀 사람",3,10),
            PostItem(1,null,"마감","청심대에서 건구스랑 놀 사람",3,10),
            PostItem(1,null,"마감","청심대에서 건구스랑 놀 사람",3,10),
            PostItem(1,null,"마감","청심대에서 건구스랑 놀 사람",3,10),
            PostItem(1,null,"마감","청심대에서 건구스랑 놀 사람",3,10),
        ))
    )

    var uriList = mutableListOf<Uri>()

    fun getDetailPost(postId : Long){

    }

    fun addUri(uri: Uri){
        uriList.add(uri)
    }

    fun mergeDateTime(selectedDate: Calendar, selectedTime: Calendar): LocalDateTime {
        // Calendar를 LocalDateTime으로 변환
        val date = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        val time = selectedTime.toInstant().atZone(ZoneId.systemDefault()).toLocalTime()

        // LocalDateTime으로 합치기
        return LocalDateTime.of(date, time)
    }

    fun isFillAllPostInfo(): Boolean{
        if(createPostInfo.component1().deadline == null){
            return false
        }
        if(createPostInfo.component1().title == null){
            return false
        }
        if(createPostInfo.component1().total_member == null){
            return false
        }
        if(createPostInfo.component1().price == null){
            return false
        }
        if(createPostInfo.component1().content == null){
            return false
        }
        return true;
    }


    fun createPostRequestFun(){
        val createPostRequest = getUserId()?.let {
            CreatePostRequest(
                deadline = createPostInfo.component1().deadline!!,
                writer_id = it,
                title = createPostInfo.component1().title!!,
                max_user_number = createPostInfo.component1().total_member!!,
                expected_price = createPostInfo.component1().price!!,
                content = createPostInfo.component1().content!!
            )
        }

        val imageParts = mutableListOf<MultipartBody.Part>()

        uriList.forEachIndexed { index, uri ->
            val file = File(uri.path!!)
            val requestBody = file.asRequestBody("image/*".toMediaTypeOrNull())
            val part = MultipartBody.Part.createFormData("image$index", file.name, requestBody)
            imageParts.add(part)
        }

        if (createPostRequest != null) {
            repository.createPostAPI(imageParts,createPostRequest)
        }
    }
}