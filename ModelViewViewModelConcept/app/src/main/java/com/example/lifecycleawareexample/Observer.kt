package com.example.lifecycleawareexample

import android.util.Log
import androidx.lifecycle.LifecycleObserver

class Observer : LifecycleObserver {

    fun onCreate(){

        Log.d("Sohil","OBSERVER-ON_CREATE")
    }
}