package com.example.jabda.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _isApprove = MutableLiveData<Boolean>()
    private val _isCard = MutableLiveData<Boolean>()
    private val _isMe = MutableLiveData<Boolean>()
    val isCard get() = _isCard
    val isApprove get() = _isApprove
    val isMe get() = _isMe


    fun setIsCard(isCard: Boolean) {
        _isCard.value = isCard
    }
    fun setIsApprove(isApprove: Boolean) {
        _isApprove.value = isApprove
    }

    fun setIsMe(isMe: Boolean) {
        _isMe.value = isMe
    }
}