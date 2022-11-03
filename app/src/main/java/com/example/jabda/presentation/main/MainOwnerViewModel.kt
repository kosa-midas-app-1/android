package com.example.jabda.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainOwnerViewModel: ViewModel() {
    private val _isNotification = MutableLiveData<Boolean>()
    private val _isPending = MutableLiveData<Boolean>()
    val isNotification get() = _isNotification
    val isPending get() = _isPending

    fun setIsNotification(isNotification: Boolean) {
        _isNotification.value = isNotification
    }
    fun setIsPending(isPending: Boolean) {
        _isPending.value = isPending
    }
}