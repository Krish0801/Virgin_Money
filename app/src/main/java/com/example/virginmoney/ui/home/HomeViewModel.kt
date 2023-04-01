package com.example.virginmoney.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Welcome to Virgin Money Employee Portal"
    }
    val text: LiveData<String> = _text
}