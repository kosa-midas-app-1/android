package com.example.jabda.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainOwnerViewModel: ViewModel() {
    private val _isNotification = MutableLiveData<Boolean>()
    private val _isPending = MutableLiveData<Boolean>()
    private val _isOwner = MutableLiveData<Boolean>()
    val isNotification get() = _isNotification
    val isPending get() = _isPending
    val isOwner get() = _isOwner

    fun setIsNotification(isNotification: Boolean) {
        _isNotification.value = isNotification
    }
    fun setIsPending(isPending: Boolean) {
        _isPending.value = isPending
    }

    fun setIsOwner(isOwner: Boolean) {
        _isOwner.value = isOwner
    }
}