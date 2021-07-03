package com.example.databindinglistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.databindinglistview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;  // used to create binding from xml..

    String name[] = {"Java", "Android", "Php", "Js"};

    int images[] = {R.drawable.java, R.drawable.android, R.drawable.php, R.drawable.js};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ListViewAdapter listViewAdapter = new ListViewAdapter(MainActivity.this, name, images);

        binding.lvName.setAdapter((ListAdapter) listViewAdapter);

    }
}
