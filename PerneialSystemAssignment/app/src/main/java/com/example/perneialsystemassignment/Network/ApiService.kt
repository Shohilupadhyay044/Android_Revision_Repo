package com.example.perneialsystemassignment.Network

import com.example.perneialsystemassignment.Model.ResponseEmployee
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/api/v1/employees")
   suspend fun getEmployee() : List<ResponseEmployee>
}