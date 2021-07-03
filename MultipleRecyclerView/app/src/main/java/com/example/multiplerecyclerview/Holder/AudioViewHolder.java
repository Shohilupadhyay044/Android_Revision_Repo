package com.example.multiplerecyclerview.Holder;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multiplerecyclerview.ItemClickListerners;
import com.example.multiplerecyclerview.Model;
import com.example.multiplerecyclerview.R;

public class AudioViewHolder extends RecyclerView.ViewHolder {


    Button mBtnAudio;
    ItemClickListerners itemClickListerners;

    MediaPlayer mediaPlayer;


    public AudioViewHolder(@NonNull View itemView,ItemClickListerners itemClickListerners) {
        super(itemView);
        this.itemClickListerners = itemClickListerners;

        mBtnAudio =itemView.findViewById(R.id.btnAudio);


    }

    public void SetAudio(Model model){

        mBtnAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
