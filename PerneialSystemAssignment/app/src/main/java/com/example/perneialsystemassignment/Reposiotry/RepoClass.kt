package com.example.perneialsystemassignment.Reposiotry

import com.example.perneialsystemassignment.Model.ResponseEmployee
import com.example.perneialsystemassignment.Network.ApiService
import com.example.perneialsystemassignment.Network.Network
import com.example.perneialsystemassignment.Network.Resource
import com.example.perneialsystemassignment.Network.ResponseHandler

class RepoClass {

    val api = Network.getInstance().create(ApiService::class.java)


       val responseHandler = ResponseHandler()

    suspend fun getData() : Resource<List<ResponseEmployee>> {
            val result = api.getEmployee()
            return  responseHandler.handleSuccess(result)

        }
    }