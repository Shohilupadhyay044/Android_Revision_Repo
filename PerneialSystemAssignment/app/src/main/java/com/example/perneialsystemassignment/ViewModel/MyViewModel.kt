package com.example.perneialsystemassignment.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.perneialsystemassignment.Model.ResponseEmployee
import com.example.perneialsystemassignment.Reposiotry.RepoClass
import kotlinx.coroutines.Dispatchers

class MyViewModel  : ViewModel() {

    val repo = RepoClass()

    val data = MutableLiveData<String>()

    fun getEmployeeData() : LiveData<List<ResponseEmployee>> {

        return liveData(Dispatchers.IO){

            val employeelist = repo.getData()
            emit(employeelist.data!!)
        }

    }




}