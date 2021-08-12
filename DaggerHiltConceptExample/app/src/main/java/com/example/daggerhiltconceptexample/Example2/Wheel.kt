package com.example.daggerhiltconceptexample.Example2

import android.util.Log
import javax.inject.Inject

class Wheel {

    @Inject
    constructor()

    fun getWheel(){

        Log.d("main", " wheel started")
    }
}