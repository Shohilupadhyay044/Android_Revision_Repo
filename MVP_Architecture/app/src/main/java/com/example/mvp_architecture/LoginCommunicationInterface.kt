package com.example.mvp_architecture

interface LoginCommunicationInterface {

    fun onSuccess(result: Boolean)
    fun onFailure(result: Boolean)
}