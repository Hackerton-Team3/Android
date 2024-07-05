package com.example.gonggoose.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.gonggoose.data.CreatePostInfo
import com.example.gonggoose.data.DetailPostInfo
import com.example.gonggoose.data.PostItem
import java.time.LocalDateTime

class HomeViewModel : ViewModel() {
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
        CreatePostInfo(null)
    )

    var detailPostInfo = mutableStateOf<DetailPostInfo>(
        DetailPostInfo(listOf(), "진행 중", "청심대에서 건구스랑 놀 사람 아ㅓㄹ아ㅓㄹ;머라;마ㅣㅓ람ㅇ러ㅏㅓ모라ㅣ머ㅗㄹㅁㄹ", 7, 100, LocalDateTime.of(2024,7,5, 17,0), null, "건구스구스", "건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ 건구스랑 놀아보자아아아아아아ㅏㅇ ")
    )

    fun createPost(){ //백엔드와 연동

    }

    fun getDetailPost(postId : Long){

    }

    fun isFillAllPostInfo(): Boolean{
        if(createPostInfo.component1().name == null){
            return false
        }
        return true;
    }

}