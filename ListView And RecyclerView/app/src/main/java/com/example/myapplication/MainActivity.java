package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_item);
        ArrayList<String> arrayList = new ArrayList<>();   // Inserting Item in ArrayList...
        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("three");
        arrayList.add("four");
        arrayList.add("five");

        // Array Adapter is used to keep data inside and show it in layout.
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(this);  //Performing event in ListView.

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       // String item = (String) listView.getSelectedItem();

      String item = (String) listView.getItemAtPosition(position);

        if(item.equals("one")){

            Toast.makeText(this, "one Clicked", Toast.LENGTH_SHORT).show();
        }
        else if(item.equals("Android")){
            Toast.makeText(this, "two Clicked", Toast.LENGTH_SHORT).show();
        }
    }
}