package com.example.daggerhiltconceptexample.Example1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerhiltconceptexample.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint  // sari functionality
class MainActivity : AppCompatActivity() {
    @Inject  // Field Injection..
    lateinit var car: Car
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        car.getCar()
    }
}