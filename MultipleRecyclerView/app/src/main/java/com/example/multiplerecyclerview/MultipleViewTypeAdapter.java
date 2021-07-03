package com.example.multiplerecyclerview;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multiplerecyclerview.Holder.AudioViewHolder;
import com.example.multiplerecyclerview.Holder.ImageViewHolder;
import com.example.multiplerecyclerview.Holder.TextViewHolder;

import java.util.List;

public class MultipleViewTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
      private List<Model> modelList;
      private ItemClickListerners itemClickListerners;
    public MultipleViewTypeAdapter(List<Model> modelList, ItemClickListerners itemClickListerners) {

        this.modelList = modelList;
        this.itemClickListerners=itemClickListerners;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       switch (viewType){

           case Model.TEXT_TYPE:

               View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text,parent,false);
               return new TextViewHolder(view,itemClickListerners);

           case Model.AUDIO_TYPE:

                   View audioview = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_audio,parent,false);
                   return new AudioViewHolder(audioview,itemClickListerners);

           case Model.IMAGE_TYPE:

               View Imageviews = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image,parent,false);
               return new ImageViewHolder(Imageviews,itemClickListerners);
       }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType = modelList.get(position).getItem_viewType();
        Model model = modelList.get(position);

        switch (viewType){

            case Model.TEXT_TYPE:
                if(holder instanceof TextViewHolder){
                    ((TextViewHolder) holder).SetText(model);
                }
                break;

            case Model.AUDIO_TYPE:
                if(holder instanceof AudioViewHolder) {
                    ((AudioViewHolder) holder).SetAudio(model);

                }
                break;

            case Model.IMAGE_TYPE:

                if(holder instanceof ImageViewHolder){
                    ((ImageViewHolder) holder).SetImage(model);
                    break;
                }

        }


    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    @Override
    public int getItemViewType(int position) {  // with the help of this method we have to return viewType to on BindMethod()
        //which we received from modelList...
        int viewType = modelList.get(position).getItem_viewType();
        return viewType;
    }
}