package com.example.gonggoose.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.gonggoose.data.ChatMessageResponse
import com.example.gonggoose.data.ChatRoomResponse
import com.example.gonggoose.data.ChattingMessage
import com.example.gonggoose.data.ChattingRoom
import com.example.gonggoose.data.Message
import com.example.gonggoose.data.UserChattingData
import com.example.gonggoose.navigation.Routes
import com.example.gonggoose.utils.RetrofitInterface
import com.example.gonggoose.utils.getKakaoId
import com.example.gonggoose.utils.getRetrofit
import com.example.gonggoose.utils.getUserId
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatViewModel : ViewModel() {

    private val _messageLoading = MutableLiveData<Boolean>()
    val messageLoading: LiveData<Boolean> get() = _messageLoading

    private val _roomLoading = MutableLiveData<Boolean>()
    val roomLoading: LiveData<Boolean> get() = _roomLoading

    //채팅방 리스트
    private val _chatRooms = MutableLiveData<List<ChattingRoom>>()
    val chatRooms: LiveData<List<ChattingRoom>> get() = _chatRooms

    //채팅
    private val _chatMessages = MutableLiveData<List<Message>>()
    val chatMessages: LiveData<List<Message>> get() = _chatMessages


    init {
        // ViewModel 초기화 시 더미 데이터로 채팅 메시지 리스트를 채웁니다.
        loadChatMessages()
        loadChatRooms()
    }


    private fun loadChatMessages() {
        val retrofitInterface = getRetrofit().create(RetrofitInterface::class.java)
            getUserId()?.let { it1 ->
                retrofitInterface.loadChatMessages(userId = 1, chatRoomId = 1) //TODO : 임시값
                    .enqueue(object : Callback<ChatMessageResponse> {
                        override fun onResponse(
                            call: Call<ChatMessageResponse>,
                            response: Response<ChatMessageResponse>
                        ) {
                            Log.d("API - 채팅메시지 조회", "onResponse: ${response.code()}")
                            if (response.isSuccessful) {
                                val resp = response.body()
                                if (resp != null) {
                                    try {
                                        _chatMessages.postValue(resp.result.messages)
                                    } catch (e: Exception) {

                                    } finally {
                                        _messageLoading.value = false // 데이터 로딩 완료
                                    }

                                }
                            } else {
                                Log.e(
                                    "API - 채팅메시지 조회",
                                    "Response 실패: ${response.errorBody()?.string()}"
                                )
                            }
                        }

                        override fun onFailure(call: Call<ChatMessageResponse>, t: Throwable) {
                            Log.e("API - 채팅메시지 조회", "onFailure", t)
                        }
                    })

        }

    }

    private fun loadChatRooms() {
        val retrofitInterface = getRetrofit().create(RetrofitInterface::class.java)
        getKakaoId()?.let {
            getUserId()?.let { it1 ->
                retrofitInterface.loadChatRooms(1)
                    .enqueue(object : Callback<ChatRoomResponse> {
                        override fun onResponse(
                            call: Call<ChatRoomResponse>,
                            response: Response<ChatRoomResponse>
                        ) {
                            Log.d("API - 채팅룸 조회", "onResponse: ${response.code()}")
                            if (response.isSuccessful) {
                                val resp = response.body()
                                if (resp != null) {
                                    try {
                                        _chatRooms.postValue(resp.result.chattingRooms)
                                    } catch (e: Exception) {

                                    } finally {
                                        _roomLoading.value = false // 데이터 로딩 완료
                                    }

                                }
                            } else {
                                Log.e(
                                    "API - 채팅룸 조회",
                                    "Response 실패: ${response.errorBody()?.string()}"
                                )
                            }
                        }

                        override fun onFailure(call: Call<ChatRoomResponse>, t: Throwable) {
                            Log.e("API - 채팅룸 조회", "onFailure", t)
                        }
                    })
            }
        }

    }

//    private fun fetchDummyChatRooms() {
//        viewModelScope.launch {
//            delay(5000)
//            try {
//                val dummyMessages = listOf(
//                    "Hello!",
//                    "How are you?",
//                    "I'm fine, thanks!",
//                    "What about you?",
//                    "I'm good too.",
//                    "Hello!",
//                    "How are you?",
//                    "I'm fine, thanks!",
//                    "What about you?",
//                    "I'm good too.",
//                    "Hello!",
//                    "How are you?",
//                    "I'm fine, thanks!",
//                    "What about you?",
//                    "I'm good too.",
//                    "Hello!",
//                    "How are you?",
//                    "I'm fine, thanks!",
//                    "What about you?",
//                    "I'm good too.",
//                    "Hello!",
//                    "How are you?",
//                    "I'm fine, thanks!",
//                    "What about you?",
//                    "I'm good too."
//                )
//                _chatRooms.value = dummyMessages
//            } catch (e: Exception) {
//                // 에러 처리
//            } finally {
//                _roomLoading.value = false // 데이터 로딩 완료
//            }
//        }
//    }
}