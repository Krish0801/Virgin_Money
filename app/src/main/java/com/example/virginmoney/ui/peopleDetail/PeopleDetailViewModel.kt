package com.example.virginmoney.ui.peopleDetail

import androidx.lifecycle.ViewModel
import com.example.virginmoney.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PeopleDetailViewModel @Inject constructor(
    repository: Repository
): ViewModel() {

}