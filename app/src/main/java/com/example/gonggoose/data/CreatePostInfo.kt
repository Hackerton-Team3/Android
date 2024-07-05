package com.example.gonggoose.data

import android.net.Uri
import java.time.LocalDateTime

data class CreatePostInfo(
    val deadline : LocalDateTime?,
    val title : String?,
    val total_member: Int?,
    val price : Int?,
    val content : String?
)
