package com.example.jabda.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _isCard = MutableLiveData<Boolean>()
    val isCard get() = _isCard

    fun setIsCard(isCard: Boolean) {
        _isCard.value = isCard
    }
}