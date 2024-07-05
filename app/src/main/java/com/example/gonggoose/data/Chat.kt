package com.example.gonggoose.data

import com.google.gson.annotations.SerializedName

data class ChattingRoom(
    @SerializedName("chattingRoomId") val chattingRoomId: Long,
    @SerializedName("chattingRoomImage") val chattingRoomImage: String,
    @SerializedName("title") val title: String,
    @SerializedName("lastComment") val lastComment: String
)

data class UserChattingData(
    @SerializedName("userId") val userId: Long,
    @SerializedName("chattingRooms") val chattingRooms: List<ChattingRoom>
)

data class ChatRoomResponse(
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: UserChattingData
)

data class ChatMessageResponse(
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: ChattingMessage
)

data class ChattingMessage(
    @SerializedName("chattingRoomId") val chattingRoomId: Long,
    @SerializedName("chattingRoomImageUrl") val chattingRoomImageUrl: String,
    @SerializedName("title") val title: String,
    @SerializedName("messages") val messages: List<Message>
)

data class Message(
    @SerializedName("chattingMessageId") val chattingMessageId: Long,
    @SerializedName("chattingRoomId") val chattingRoomId: Long,
    @SerializedName("content") val content: String,
    @SerializedName("createAt") val createAt: String
)