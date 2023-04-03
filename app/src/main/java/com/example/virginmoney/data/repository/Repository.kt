package com.example.virginmoney.data.repository

import com.example.virginmoney.data.model.people.PeopleModel
import com.example.virginmoney.data.model.people.PeopleModelItemModel
import com.example.virginmoney.data.model.rooms.RoomsModel
import com.example.virginmoney.data.model.rooms.RoomsModelItemModel


interface Repository {

    suspend fun getPeople() : ArrayList<PeopleModelItemModel>

    suspend fun getRooms() : ArrayList<RoomsModelItemModel>
}