package com.example.daggerhiltconceptexample.Example2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerhiltconceptexample.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ConstructorInjectionDaggerHilt : AppCompatActivity() {

    @Inject
    lateinit var car2: Car2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_constructor_injection_dagger_hilt)
        car2.getCar()
    }
}