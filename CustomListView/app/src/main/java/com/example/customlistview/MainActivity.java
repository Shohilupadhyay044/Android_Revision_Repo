package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearSmoothScroller;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_item);

        String mainTitle[] = {"Java", "Android", "php","js"};

        String subtitle[] = {"core", "Marshmallow","Php", "JavaScript"};

        Integer images[] = {R.drawable.java, R.drawable.android,R.drawable.php, R.drawable.js};


        MyAdapter myAdapter = new MyAdapter(this,mainTitle,subtitle,images);

        listView.setAdapter(myAdapter);



    }
}