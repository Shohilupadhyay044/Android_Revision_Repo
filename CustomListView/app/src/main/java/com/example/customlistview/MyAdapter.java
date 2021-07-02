package com.example.customlistview;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyAdapter extends ArrayAdapter<String> {
    public Activity context;
    public String mainTitle[];
    public String subTitle[];

    public Integer images[];
    public MyAdapter(Activity context, String[] mainTitle, String[] subtitle, Integer[] images) {
        super(context,R.layout.row,mainTitle);
        this.context = context;
        this.mainTitle=mainTitle;
        this.subTitle=subtitle;
        this.images=images;
    }
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater layoutInflater =context.getLayoutInflater();
        View rowView=layoutInflater.inflate(R.layout.row, null,true);
       TextView title = rowView.findViewById(R.id.title);
       TextView Subtitle = rowView.findViewById(R.id.subTitle);
        ImageView imageView = rowView.findViewById(R.id.image);
        title.setText(mainTitle[position]);
        Subtitle.setText(subTitle[position]);
        imageView.setImageResource(images[position]);
        return rowView;
    }
}
