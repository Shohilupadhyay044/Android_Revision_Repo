package com.example.databindinglistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;

import com.example.databindinglistview.databinding.ViewItemBinding;

public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private String name[];
    private int image[];

    LayoutInflater layoutInflater;

    public ListViewAdapter(MainActivity mainActivity, String[] name, int[] images) {
        this.context=mainActivity;
        this.name = name;
        this.image = images;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewItemBinding binding;
//        convertView = layoutInflater.inflate(R.layout.view_item,null);
//        binding = DataBindingUtil.bind(convertView);
//        convertView.setTag(binding);
//      binding.setName(name[position]);
//        binding.setImage(image[position]);
//        return binding.getRoot();

        return null;

    }
}
