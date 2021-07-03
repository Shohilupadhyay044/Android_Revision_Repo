package com.example.databindinglayoutbasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.databindinglayoutbasic.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
 ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
       binding.setUser(new User("Coco"));
       binding.setActivity(new MainActivity());
    }

    public void onMessage(View view, String strMsg){
        Toast.makeText(view.getContext(),strMsg,Toast.LENGTH_LONG).show();
    }
}