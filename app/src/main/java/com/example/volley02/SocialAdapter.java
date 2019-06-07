package com.example.volley02;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SocialAdapter extends RecyclerView.Adapter<SocialAdapter.ViewHolder> {

    private ArrayList<Social> items = new ArrayList<>();

    @NonNull
    @Override
    public SocialAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i){

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_social,parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SocialAdapter.ViewHolder viewHolder, int position){

        Social item = items.get(position);

        Glide.with(viewHolder.itemView.getContext())
                .load(item.getUrl())
                .into(viewHolder.ivSocial);

        viewHolder.tvTitle.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Social>items){
        this.items = items;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivSocial;
        TextView tvTitle;

        ViewHolder(View itemView){
            super(itemView);

            ivSocial = itemView.findViewById(R.id.iv_item_social);

            tvTitle = itemView.findViewById(R.id.tv_item_social_title);
        }
    }
}
