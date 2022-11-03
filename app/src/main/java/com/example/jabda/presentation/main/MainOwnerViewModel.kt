package com.example.jabda.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainOwnerViewModel: ViewModel() {
    private val _isNotification = MutableLiveData<Boolean>()
    val isNotification get() = _isNotification

    fun setIsNotification(isNotification: Boolean) {
        _isNotification.value = isNotification
    }
}