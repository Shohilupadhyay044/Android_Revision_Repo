package com.example.livedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.factsLiveData.observe(this, Observer {

             factTextView.text =it
        })

        btnUpdate.setOnClickListener {

            mainViewModel.updateLiveData()
        }
    }
}

/*
LiveData is basically a data holder and it is used to observe the changes of a particular view and then update the corresponding change.
It is lifecycle-aware i.e. whenever a data is updated or changed then the updates will be sent to only those app components which are in active state.
If the app component is not active and in the future, if it becomes active, then the updated data will be sent to that app component.
So, you need not worry about the lifecycle of the app component while updating data.


 Four basic steps to work with LiveData
In order to use LiveData in your project, all you need to do is follow the below four steps:
Firstly, for holding the data, you need to create a LiveData instance in your ViewModel.
After creating the instance of LiveData, you need to set the data in the LiveData by using methods like setValue and postValue.
After that, you need to return the LiveData so that it can be observed by some observer in the views like Activity or Fragments.
And finally, you need to observe the data in your views with the help of observe method. In the observer, you need to define all the
changes in the UI that you want to perform on data change.
After following the above four steps, whenever there is a change in the data stored in LiveData then all the observers associated with the
LiveData will be notified if they are live otherwise they will be notified when they come into the resume state.




 */