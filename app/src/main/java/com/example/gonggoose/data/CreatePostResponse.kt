package com.example.gonggoose.data

data class CreatePostResponse(
    val code : Int,
    val status : Int,
    val message : String,
    val result : Bulletin_id
)

data class Bulletin_id(
    val bulletin_id :Long
)