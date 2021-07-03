package com.example.multiplerecyclerview.Holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multiplerecyclerview.ItemClickListerners;
import com.example.multiplerecyclerview.Model;
import com.example.multiplerecyclerview.R;

public class TextViewHolder extends RecyclerView.ViewHolder {

    TextView tvTextView;
    ItemClickListerners itemClickListerners;
    public TextViewHolder(@NonNull View itemView, ItemClickListerners itemClickListerners) {
        super(itemView);
        this.itemClickListerners = itemClickListerners;
        tvTextView=itemView.findViewById(R.id.tvText);
    }

    public void SetText(Model model){
        tvTextView.setText(model.getContent());


    }
}
