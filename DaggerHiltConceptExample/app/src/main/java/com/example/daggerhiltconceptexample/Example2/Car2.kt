package com.example.daggerhiltconceptexample.Example2

import android.util.Log
import javax.inject.Inject

class Car2 @Inject constructor(private val engine: Engine, private var wheel: Wheel){

    fun getCar(){

        engine.getEngine()
        wheel.getWheel()
        Log.d("main","car is running")
    }

}