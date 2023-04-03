package com.example.virginmoney.data.remote

import com.example.virginmoney.data.model.people.PeopleModelItemModel
import com.example.virginmoney.data.model.rooms.RoomsModel
import com.example.virginmoney.data.model.rooms.RoomsModelItemModel
import retrofit2.http.GET

interface ApiRequest {

    @GET(ApiDetails.PEOPLE)
    suspend fun getPeople() : ArrayList<PeopleModelItemModel>

    @GET(ApiDetails.ROOMS)
    suspend fun getRooms() : ArrayList<RoomsModelItemModel>
}