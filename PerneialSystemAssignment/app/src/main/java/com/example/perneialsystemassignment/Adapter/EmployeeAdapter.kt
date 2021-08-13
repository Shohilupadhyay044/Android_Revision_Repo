package com.example.perneialsystemassignment.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.perneialsystemassignment.MainActivity
import com.example.perneialsystemassignment.Model.ResponseEmployee
import com.example.perneialsystemassignment.R

class EmployeeAdapter(private var employeelist: List<ResponseEmployee>, private val mainActivity: MainActivity) : RecyclerView.Adapter<EmployeeHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return EmployeeHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeHolder, position: Int) {
        val employee = employeelist[position]
        holder.setData(employee)

    }

    override fun getItemCount(): Int {
      return employeelist.size
    }

    fun update(employeelist: List<ResponseEmployee>) {
        this.employeelist = employeelist
        notifyDataSetChanged()

    }
}