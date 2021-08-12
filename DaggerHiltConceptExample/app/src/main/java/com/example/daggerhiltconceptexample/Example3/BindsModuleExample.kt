package com.example.daggerhiltconceptexample.Example3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerhiltconceptexample.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BindsModuleExample : AppCompatActivity() {

    @Inject

    lateinit var main: Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binds_module_example)
        main.getName()
    }
}