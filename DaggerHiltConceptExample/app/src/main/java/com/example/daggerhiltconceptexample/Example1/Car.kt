package com.example.daggerhiltconceptexample.Example1

import android.util.Log
import javax.inject.Inject

class Car {

    @Inject
    constructor()


    fun getCar(){
     // Source code..
        Log.d("main", "car is running")
    }
}