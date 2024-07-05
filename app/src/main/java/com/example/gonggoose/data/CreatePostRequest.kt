package com.example.gonggoose.data

import java.time.LocalDateTime

data class CreatePostRequest(
    val deadline : LocalDateTime,
    val writer_id : Long,
    val title : String,
    val max_user_number : Int,
    val expected_price : Int,
    val content : String
)
