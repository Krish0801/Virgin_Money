package com.example.virginmoney.ui.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoney.data.model.people.PeopleModel
import com.example.virginmoney.data.model.rooms.RoomsModel
import com.example.virginmoney.data.remote.ApiDetails
import com.example.virginmoney.data.remote.ApiRequest
import com.example.virginmoney.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {

    val people = MutableLiveData<PeopleModel>()

    fun getPeople() {

        viewModelScope.launch {
            val result = repository.getPeople()
            people.postValue(result)
        }

    }
}