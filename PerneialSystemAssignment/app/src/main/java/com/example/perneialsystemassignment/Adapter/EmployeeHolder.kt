package com.example.perneialsystemassignment.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.perneialsystemassignment.Model.ResponseEmployee
import kotlinx.android.synthetic.main.item_layout.view.*

class EmployeeHolder(val view : View) : RecyclerView.ViewHolder(view) {

    fun setData(employee: ResponseEmployee){

        view.apply {

            tvid.text = employee.status
        }
    }
}