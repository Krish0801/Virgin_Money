package com.example.virginmoney.ui.rooms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RoomsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Rooms Fragment"
    }
    val text: LiveData<String> = _text
}