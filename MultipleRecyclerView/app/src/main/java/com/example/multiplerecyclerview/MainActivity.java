package com.example.multiplerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListerners {
    private RecyclerView recyclerView;
    private List<Model> modelList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.Recycler);
        buildModelList();
        setRecyclerAdapter();
    }
    private void buildModelList() {
        modelList.add(new Model("This is Simple Text Header",0,Model.TEXT_TYPE));
        modelList.add(new Model("This is How the senery look like",R.drawable.ic_launcher_background,Model.IMAGE_TYPE));
        modelList.add(new Model("Shape of You",R.raw.song,Model.AUDIO_TYPE));
        modelList.add(new Model("This is Simple Text Header",0,Model.TEXT_TYPE));
        modelList.add(new Model("This is How the senery look like",R.drawable.ic_launcher_background,Model.IMAGE_TYPE));
        modelList.add(new Model("Shape of You",R.raw.song,Model.AUDIO_TYPE));
        modelList.add(new Model("This is Simple Text Header",0,Model.TEXT_TYPE));
        modelList.add(new Model("This is How the senery look like",R.drawable.ic_launcher_background,Model.IMAGE_TYPE));
        modelList.add(new Model("Shape of You",R.raw.song,Model.AUDIO_TYPE));
        modelList.add(new Model("This is Simple Text Header",0,Model.TEXT_TYPE));
        modelList.add(new Model("This is How the senery look like",R.drawable.ic_launcher_background,Model.IMAGE_TYPE));
        modelList.add(new Model("Shape of You",R.raw.song,Model.AUDIO_TYPE));
        modelList.add(new Model("Shape of You",R.raw.song,Model.AUDIO_TYPE));
        modelList.add(new Model("This is Simple Text Header",0,Model.TEXT_TYPE));
        modelList.add(new Model("This is How the senery look like",R.drawable.ic_launcher_background,Model.IMAGE_TYPE));
        modelList.add(new Model("Shape of You",R.raw.song,Model.AUDIO_TYPE));
        modelList.add(new Model("Shape of You",R.raw.song,Model.AUDIO_TYPE));
        modelList.add(new Model("This is Simple Text Header",0,Model.TEXT_TYPE));
        modelList.add(new Model("This is How the senery look like",R.drawable.ic_launcher_background,Model.IMAGE_TYPE));
        modelList.add(new Model("Shape of You",R.raw.song,Model.AUDIO_TYPE));
        modelList.add(new Model("This is Simple Text Header",0,Model.TEXT_TYPE));
        modelList.add(new Model("This is How the senery look like",R.drawable.ic_launcher_background,Model.IMAGE_TYPE));
        modelList.add(new Model("Shape of You",R.raw.song,Model.AUDIO_TYPE));
        modelList.add(new Model("This is Simple Text Header",0,Model.TEXT_TYPE));
        modelList.add(new Model("This is How the senery look like",R.drawable.ic_launcher_background,Model.IMAGE_TYPE));
        modelList.add(new Model("Shape of You",R.raw.song,Model.AUDIO_TYPE));
        modelList.add(new Model("Shape of You",R.raw.song,Model.AUDIO_TYPE));
        modelList.add(new Model("This is Simple Text Header",0,Model.TEXT_TYPE));
    }
    private void setRecyclerAdapter() {
        MultipleViewTypeAdapter multipleViewTypeAdapter = new MultipleViewTypeAdapter(modelList,this);
        LinearLayoutManager linearLayoutManager  = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(multipleViewTypeAdapter);
    }

    @Override
    public void OnItemClickListeners(Model model) {

    }
}
