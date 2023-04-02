package com.example.virginmoney.data.model.rooms


import com.example.virginmoney.data.model.people.DataModel
import com.google.gson.annotations.SerializedName

class RoomsModel : ArrayList<RoomsModelItemModel>() {
        @SerializedName("data")
        val data: List<RoomsModelItemModel>? = listOf()
}