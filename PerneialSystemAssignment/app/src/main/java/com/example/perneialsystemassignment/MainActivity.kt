package com.example.perneialsystemassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.perneialsystemassignment.Adapter.EmployeeAdapter
import com.example.perneialsystemassignment.Model.ResponseEmployee
import com.example.perneialsystemassignment.ViewModel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val employeelist : List<ResponseEmployee> = listOf()
    private lateinit var employeeAdapter: EmployeeAdapter
    private var viewModel = MyViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecyclerViewAdapter()
        setData()

    }

    private fun setData() {
       viewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        viewModel.getEmployeeData().observe(this, Observer {
            var value =it
            employeeAdapter.update(value)
        })
    }

    private fun setRecyclerViewAdapter() {

        employeeAdapter = EmployeeAdapter(employeelist,this)
        val linearLayoutManager = LinearLayoutManager(this)

        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        recycler.layoutManager = linearLayoutManager
        recycler.adapter = employeeAdapter

    }
}