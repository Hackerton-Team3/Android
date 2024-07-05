package com.example.gonggoose.data

import java.time.LocalDateTime

data class DetailPostInfo(
    val imageUrlList : List<String>,
    val tag : String,
    val title :String,
    val current_member: Int,
    val total_member:Int,
    val deadline : LocalDateTime,

    val userImage :String?,
    val userName : String,

    val detailContent: String
)
