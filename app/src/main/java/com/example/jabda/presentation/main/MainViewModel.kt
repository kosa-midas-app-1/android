package com.example.jabda.presentation.main

import android.app.Notification
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _isApprove = MutableLiveData<Boolean>()
    private val _isCard = MutableLiveData<Boolean>()
    private val _isMe = MutableLiveData<Boolean>()
    private val _isNotification = MutableLiveData<Boolean>()
    private val _isDetail = MutableLiveData<Boolean>()
    val isCard get() = _isCard
    val isApprove get() = _isApprove
    val isMe get() = _isMe
    val isNotification get() = _isNotification
    val isDetail get() = _isDetail


    fun setIsCard(isCard: Boolean) {
        _isCard.value = isCard
    }
    fun setIsApprove(isApprove: Boolean) {
        _isApprove.value = isApprove
    }

    fun setIsMe(isMe: Boolean) {
        _isMe.value = isMe
    }

    fun setIsNotification(isNotification: Boolean) {
        _isNotification.value = isNotification
    }

    fun setIsDetail(isDetail: Boolean) {
        _isDetail.value = isDetail
    }
}