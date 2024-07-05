package com.example.gonggoose.data

data class UserInfo(
    val userId:Long,
    val imageUrl : String?,
    val university : String,
    val userName : String,
    val participatedPostList : List<PostItem>
)
