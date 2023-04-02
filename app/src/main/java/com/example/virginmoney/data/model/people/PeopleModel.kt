package com.example.virginmoney.data.model.people


import com.google.gson.annotations.SerializedName

class PeopleModel : ArrayList<PeopleModelItemModel>(){
@SerializedName("data")
val data: List<PeopleModelItemModel> = listOf()
}