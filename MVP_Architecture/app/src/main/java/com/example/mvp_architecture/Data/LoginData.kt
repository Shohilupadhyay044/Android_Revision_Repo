package com.example.mvp_architecture.Data

class LoginData {

    fun validateLogin(userName : String, password : String) : Boolean{

        if(userName ==("admin") && password ==("12345")){
            return true;
        }
        else{
            return false
        }
    }
}