package com.example.viewmodel

import androidx.lifecycle.ViewModel

class MyViewModel(val initialValue :Int) : ViewModel() {
    var count  =0;
    fun increment(){
        count++
    }
}