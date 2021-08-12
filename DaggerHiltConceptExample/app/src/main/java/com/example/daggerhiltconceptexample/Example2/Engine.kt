package com.example.daggerhiltconceptexample.Example2

import android.util.Log
import javax.inject.Inject

class Engine {

    @Inject  // We provide a dependency from here
    constructor()
    fun getEngine(){
        Log.d("main", "Engine started ..")
    }
}