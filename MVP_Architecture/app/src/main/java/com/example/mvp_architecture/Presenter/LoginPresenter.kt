package com.example.mvp_architecture.Presenter

import com.example.mvp_architecture.Data.LoginData
import com.example.mvp_architecture.LoginCommunicationInterface

class LoginPresenter(val loginCommunicationInterface: LoginCommunicationInterface) {

    val loginData  = LoginData()

      fun login (userName: String , password : String){
         val result = loginData.validateLogin(userName,password)
          if(result){
              loginCommunicationInterface.onSuccess(result)
          }else{
              loginCommunicationInterface.onFailure(result)
          }
      }
}