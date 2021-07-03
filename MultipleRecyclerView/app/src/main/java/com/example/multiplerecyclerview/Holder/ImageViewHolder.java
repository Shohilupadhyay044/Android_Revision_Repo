package com.example.multiplerecyclerview.Holder;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multiplerecyclerview.ItemClickListerners;
import com.example.multiplerecyclerview.Model;
import com.example.multiplerecyclerview.R;

public class ImageViewHolder extends RecyclerView.ViewHolder {

    ItemClickListerners itemClickListerners;

    ImageView ivImageView;
    public ImageViewHolder(@NonNull View itemView,ItemClickListerners itemClickListerners) {
        super(itemView);
        this.itemClickListerners = itemClickListerners;
        ivImageView =itemView.findViewById(R.id.ivImage);
    }

    public void SetImage(Model model){
        ivImageView.setImageResource(model.getResId());
    }
}
