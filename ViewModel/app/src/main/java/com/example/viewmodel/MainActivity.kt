package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myViewModel : MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          myViewModel = ViewModelProvider(this, MyViewModelFactory(10)).get(MyViewModel::class.java)
            tvIncrement.text = myViewModel.count.toString()


        incrementCount.setOnClickListener {

            myViewModel.increment()
            tvIncrement.text = myViewModel.count.toString()


        }
    }
}