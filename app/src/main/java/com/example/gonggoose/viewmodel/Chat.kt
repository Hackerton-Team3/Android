package com.example.gonggoose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {

    private val _messageLoading = MutableLiveData<Boolean>()
    val messageLoading: LiveData<Boolean> get() = _messageLoading

    private val _roomLoading = MutableLiveData<Boolean>()
    val roomLoading: LiveData<Boolean> get() = _roomLoading

    //채팅방 리스트
    private val _chatRooms = MutableLiveData<List<String>>()
    val chatRooms: LiveData<List<String>> get() = _chatRooms

    //채팅
    private val _chatMessages = MutableLiveData<List<String>>()
    val chatMessages: LiveData<List<String>> get() = _chatMessages



    init {
        // ViewModel 초기화 시 더미 데이터로 채팅 메시지 리스트를 채웁니다.
        fetchDummyChatMessages()
        fetchDummyChatRooms()
    }

    private fun fetchDummyChatMessages() {
        viewModelScope.launch {
            delay(5000)
            try {
                val dummyMessages = listOf(
                    "Hello!",
                    "How are you?",
                    "I'm fine, thanks!",
                    "What about you?",
                    "I'm good too.",
                    "Hello!",
                    "How are you?",
                    "I'm fine, thanks!",
                    "What about you?",
                    "I'm good too.",
                    "Hello!",
                    "How are you?",
                    "I'm fine, thanks!",
                    "What about you?",
                    "I'm good too.",
                    "Hello!",
                    "How are you?",
                    "I'm fine, thanks!",
                    "What about you?",
                    "I'm good too.",
                    "Hello!",
                    "How are you?",
                    "I'm fine, thanks!",
                    "What about you?",
                    "I'm good too."
                )
                _chatMessages.value = dummyMessages
            } catch (e: Exception) {
                // 에러 처리
            } finally {
                _messageLoading.value = false // 데이터 로딩 완료
            }
        }
    }

    private fun fetchDummyChatRooms() {
        viewModelScope.launch {
            delay(5000)
            try {
                val dummyMessages = listOf(
                    "Hello!",
                    "How are you?",
                    "I'm fine, thanks!",
                    "What about you?",
                    "I'm good too.",
                    "Hello!",
                    "How are you?",
                    "I'm fine, thanks!",
                    "What about you?",
                    "I'm good too.",
                    "Hello!",
                    "How are you?",
                    "I'm fine, thanks!",
                    "What about you?",
                    "I'm good too.",
                    "Hello!",
                    "How are you?",
                    "I'm fine, thanks!",
                    "What about you?",
                    "I'm good too.",
                    "Hello!",
                    "How are you?",
                    "I'm fine, thanks!",
                    "What about you?",
                    "I'm good too."
                )
                _chatRooms.value = dummyMessages
            } catch (e: Exception) {
                // 에러 처리
            } finally {
                _roomLoading.value = false // 데이터 로딩 완료
            }
        }
    }
}