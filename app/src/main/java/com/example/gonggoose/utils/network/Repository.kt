package com.example.gonggoose.utils.network

import androidx.navigation.NavController
import com.example.gonggoose.data.CreatePostRequest
import com.example.gonggoose.utils.RetrofitInterface
import com.example.gonggoose.utils.getRetrofit
import okhttp3.MultipartBody

class Repository {
    fun createPostAPI(imageParts : List<MultipartBody.Part>, createPostRequest : CreatePostRequest) {

        val response = getRetrofit()
            .create(RetrofitInterface::class.java)
            .createPost(
                images = imageParts,
                request = createPostRequest
            )
    }
}


