package com.example.gonggoose.data

data class PostItem(
    val postId :Long,
    val imageUrl : String?,
    val tag : String,
    val title : String,
    val current_member: Int,
    val total_member: Int
)