package com.example.gonggoose.data

import android.net.Uri
import java.time.LocalDateTime

data class CreatePostInfo(
    var deadline : LocalDateTime?,
    var title : String?,
    var total_member: Int?,
    var price : Int?,
    var content : String?
)
